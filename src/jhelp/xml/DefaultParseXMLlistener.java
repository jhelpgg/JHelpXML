/**
 * <h1>License :</h1> <br>
 * The following code is deliver as is. I take care that code compile and work, but I am not responsible about any damage it may
 * cause.<br>
 * You can use, modify, the code as your need for any usage. But you can't do any action that avoid me or other person use,
 * modify this code. The code is free for usage and modification, you can't change that fact.<br>
 * <br>
 * 
 * @author JHelp
 */
package jhelp.xml;

import java.util.Enumeration;
import java.util.Hashtable;

import jhelp.util.debug.Debug;

/**
 * Default parser XML listener.<br>
 * It complete while reading in a {@link MarkupXML}<br>
 * <br>
 * Last modification : 22 fevr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class DefaultParseXMLlistener
      implements ParseXMLlistener
{
   /** Read markup XML */
   private MarkupXML markupXML;
   /** Temporary markup */
   private MarkupXML temporary;
   /** Temporary parent */
   private MarkupXML temporaryParent;

   /**
    * Constructs DefaultParseXMLlistener
    */
   public DefaultParseXMLlistener()
   {
   }

   /**
    * Call when comment find
    * 
    * @param comment
    *           Comment
    * @see jhelp.xml.ParseXMLlistener#commentFind(java.lang.String)
    */
   @Override
   public void commentFind(final String comment)
   {
   }

   /**
    * Call when read a end of markup
    * 
    * @param markupName
    *           Markup name
    * @throws UnexpectedEndOfMarkup
    *            If end of is markup append at wrong moment
    * @see jhelp.xml.ParseXMLlistener#endMarkup(java.lang.String)
    */
   @Override
   public void endMarkup(final String markupName) throws UnexpectedEndOfMarkup
   {
      if(this.temporaryParent != null)
      {
         this.temporary = this.temporaryParent;
         this.temporaryParent = this.temporary.getParent();
      }
   }

   /**
    * Call when parse if finish
    * 
    * @throws UnexpectedEndOfParse
    *            If parse can't finish now
    * @see jhelp.xml.ParseXMLlistener#endParse()
    */
   @Override
   public void endParse() throws UnexpectedEndOfParse
   {
      this.temporary = null;
      this.temporaryParent = null;
   }

   /**
    * Call when an exception force the end of parse
    * 
    * @param exceptionParseXML
    *           Exception append
    * @see jhelp.xml.ParseXMLlistener#exceptionForceEndParse(jhelp.xml.ExceptionParseXML)
    */
   @Override
   public void exceptionForceEndParse(final ExceptionParseXML exceptionParseXML)
   {
      Debug.printException(exceptionParseXML);

      this.temporary = null;
      this.temporaryParent = null;
   }

   /**
    * Read markup
    * 
    * @return Read markup
    */
   public MarkupXML getMarkupXML()
   {
      return this.markupXML;
   }

   /**
    * Call when read a start of markup
    * 
    * @param markupName
    *           Markup name
    * @param parameters
    *           Parameters found in markup
    * @throws MissingRequiredParameterException
    *            If a required parameter missing
    * @throws InvalidParameterValueException
    *            If a parameter have an invalid value
    * @see jhelp.xml.ParseXMLlistener#startMakup(java.lang.String, java.util.Hashtable)
    */
   @Override
   public void startMakup(final String markupName, final Hashtable<String, String> parameters) throws MissingRequiredParameterException,
         InvalidParameterValueException
   {
      if(this.markupXML == null)
      {
         this.temporary = this.markupXML = new MarkupXML(markupName);
      }
      else
      {
         this.temporaryParent = this.temporary;
         this.temporary = new MarkupXML(markupName);
      }
      if(this.temporaryParent != null)
      {
         this.temporaryParent.addChild(this.temporary);
      }
      //
      final Enumeration<String> keys = parameters.keys();
      String key;
      while(keys.hasMoreElements())
      {
         key = keys.nextElement();
         this.temporary.addParameter(key, parameters.get(key));
      }
   }

   /**
    * Call on start parsing
    * 
    * @see jhelp.xml.ParseXMLlistener#startParse()
    */
   @Override
   public void startParse()
   {
      this.markupXML = null;
      this.temporary = null;
      this.temporaryParent = null;
   }

   /**
    * Call when text find
    * 
    * @param text
    *           Text find
    * @throws InvalidTextException
    *            If text is not valid
    * @see jhelp.xml.ParseXMLlistener#textFind(java.lang.String)
    */
   @Override
   public void textFind(final String text) throws InvalidTextException
   {
      this.temporary.setText(text);
   }
}