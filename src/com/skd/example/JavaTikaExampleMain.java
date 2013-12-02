package com.skd.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;
import org.apache.tika.sax.ToXMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class JavaTikaExampleMain {
	
	public static void main(String[] args){
		
		InputStream stream = null;
		try {
			stream = new FileInputStream("res/test.docx");
			ContentHandler handler = new ToXMLContentHandler();
			Metadata meta = new Metadata();
//			new OfficeParser().parse(stream, handler, meta, new ParseContext()); // Word 2003
			new OOXMLParser().parse(stream, handler, meta, new ParseContext()); // Word 2007
			System.out.println(handler.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
