/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.translations;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Aleksander
 */
public class XMLLangLoader extends LangLoader {
    public XMLLangLoader(String pathname) throws IOException {
        super(pathname);
        
        if (!isXML(pathname)) {
            throw new IOException("XML file must have a .xml extension");
        }
    }
    
    @Override
    public void load() {
        try {
            Document document = (Document) new SAXBuilder().build(this);
            
            Element root = document.getRootElement();
            for (Element soft : root.getChildren()) {
                for (Element translation : soft.getChildren()) {
                    this.registerTranslation(soft.getName(), translation);
                }
            }
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(XMLLangLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void registerTranslation(String soft, Element element) {
        String id = element.getName();
        String message = element.getText();
        
        this.addMessage(soft + "." + id, message);
    }
    
    public static boolean isXML(String filename) {
        return FilenameUtils.isExtension(filename, "xml");
    }
    
    public static void loadXMLTranslations(File directory) {
        if (!directory.exists()) {
            return;
        }
        
        Map<Locale, XMLLangLoader> translations = new HashMap<>();
        for (File file : directory.listFiles()) {
            if (!file.isFile() || !XMLLangLoader.isXML(file.getName())) {
                continue;
            }
            
            try {
                XMLLangLoader loader = new XMLLangLoader(directory + File.separator + file.getName());
                loader.load();
                translations.put(LocaleUtils.toLocale(FilenameUtils.removeExtension(file.getName())), loader);
            } catch (IOException ex) {
                Logger.getLogger(XMLLangLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (Locale locale : translations.keySet()) {
            XMLLangLoader xml = translations.get(locale);
            Map<String, String> messages = xml.getMessages();
            
            for (String id : messages.keySet()) {
                Translations.getMessage(id).add(locale, messages.get(id));
            }
        }
    }
}
