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

/**
 * Verbose parse XML listener.<br>
 * Write each step of parsing<br>
 * Generally use in debugging purpose <br>
 * <br>
 * Last modification : 22 fevr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class VerboseParseXMLlistener
      implements ParseXMLlistener
{

   /**
    * Constructs VerboseParseXMLlistener
    */
   public VerboseParseXMLlistener()
   {
   }

   /**
    * When comment find
    * 
    * @param comment
    *           Comment
    * @see jhelp.xml.ParseXMLlistener#commentFind(java.lang.String)
    */
   @Override
   public void commentFind(final String comment)
   {
      System.out.println("COMMENT : " + comment);
   }

   /**
    * Call when markup end
    * 
    * @param markupName
    *           Markup name
    * @throws UnexpectedEndOfMarkup
    *            If markup can't close now
    * @see jhelp.xml.ParseXMLlistener#endMarkup(java.lang.String)
    */
   @Override
   public void endMarkup(final String markupName) throws UnexpectedEndOfMarkup
   {
      System.out.println("END MARKUP : " + markupName);
   }

   /**
    * Call when parsing end
    * 
    * @throws UnexpectedEndOfParse
    *            If parsing can't end now
    * @see jhelp.xml.ParseXMLlistener#endParse()
    */
   @Override
   public void endParse() throws UnexpectedEndOfParse
   {
      System.out.println("--- END ---");
   }

   /**
    * Call when exception append
    * 
    * @param exceptionParseXML
    *           Exception
    * @see jhelp.xml.ParseXMLlistener#exceptionForceEndParse(jhelp.xml.ExceptionParseXML)
    */
   @Override
   public void exceptionForceEndParse(final ExceptionParseXML exceptionParseXML)
   {
      System.out.println("EXCEPTION : " + exceptionParseXML);
   }

   /**
    * Call on start markup
    * 
    * @param markupName
    *           Markup name
    * @param parameters
    *           Parameters
    * @throws MissingRequiredParameterException
    *            If required parameters miss
    * @throws InvalidParameterValueException
    *            If parameter value not valid
    * @see jhelp.xml.ParseXMLlistener#startMakup(java.lang.String, java.util.Hashtable)
    */
   @Override
   public void startMakup(final String markupName, final Hashtable<String, String> parameters) throws MissingRequiredParameterException,
         InvalidParameterValueException
   {
      System.out.println("START MARKUP : " + markupName);
      final Enumeration<String> keys = parameters.keys();
      String key;
      while(keys.hasMoreElements() == true)
      {
         key = keys.nextElement();

         System.out.print("\n\t");
         System.out.print(key);
         System.out.print("=");
         System.out.println(parameters.get(key));
      }
   }

   /**
    * Call when parse starts
    * 
    * @see jhelp.xml.ParseXMLlistener#startParse()
    */
   @Override
   public void startParse()
   {
      System.out.println("--- START ---");
   }

   /**
    * Call when text find
    * 
    * @param text
    *           Text find
    * @throws InvalidTextException
    *            If text invalid
    * @see jhelp.xml.ParseXMLlistener#textFind(java.lang.String)
    */
   @Override
   public void textFind(final String text) throws InvalidTextException
   {
      System.out.println("TEXT : " + text);
   }
}