/**
 * Project : JHelpXML<br>
 * Package : jhelp.xml<br>
 * Class : DefaultParseXMLprogressListener<br>
 * Date : 21 fevr. 2009<br>
 * By JHelp
 */
package jhelp.xml;


/**
 * XML parser progress listener by default <br>
 * <br>
 * Last modification : 21 fevr. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class DiscretParseXMLprogressListener
      implements ParseXMLprogressListener
{

   /**
    * Constructs DefaultParseXMLprogressListener
    */
   public DiscretParseXMLprogressListener()
   {
   }

   /**
    * Call when exception append
    * 
    * @param exceptionParseXML
    *           Exception
    * @see jhelp.xml.ParseXMLprogressListener#exceptionAppend(jhelp.xml.ExceptionParseXML)
    */
   @Override
   public void exceptionAppend(final ExceptionParseXML exceptionParseXML)
   {
   }

   /**
    * Call when a markup close meet
    * 
    * @param markupName
    *           Markup name
    * @param line
    *           Line of meeting
    * @param column
    *           Column of meeting
    * @see jhelp.xml.ParseXMLprogressListener#findCloseMarkup(java.lang.String, int, int)
    */
   @Override
   public void findCloseMarkup(final String markupName, final int line, final int column)
   {
   }

   /**
    * Call when a markup open meet
    * 
    * @param markupName
    *           Markup name
    * @param line
    *           Line of meeting
    * @param column
    *           Column of meeting
    * @see jhelp.xml.ParseXMLprogressListener#findOpenMarkup(java.lang.String, int, int)
    */
   @Override
   public void findOpenMarkup(final String markupName, final int line, final int column)
   {
   }

   /**
    * Call when parameter meet
    * 
    * @param markupName
    *           Markup name
    * @param parameterName
    *           Parameter name
    * @param line
    *           Line
    * @param column
    *           Column
    * @see jhelp.xml.ParseXMLprogressListener#findParameter(java.lang.String, java.lang.String, int, int)
    */
   @Override
   public void findParameter(final String markupName, final String parameterName, final int line, final int column)
   {
   }

   /**
    * Call when meet a text
    * 
    * @param markupName
    *           Markup name
    * @param text
    *           Text
    * @param line
    *           Line
    * @param column
    *           Column
    * @see jhelp.xml.ParseXMLprogressListener#findTextMarkup(java.lang.String, java.lang.String, int, int)
    */
   @Override
   public void findTextMarkup(final String markupName, final String text, final int line, final int column)
   {
   }
}