/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.thin.app.office.contact.app;

/**
 * OrderEntry.java:   Applet
 *  Copyright � 1997 jbundle.org. All rights reserved.
 *  
 *  @author Don Corley don@tourgeek.com
 *  @version 1.0.0.
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.util.Map;

import javax.swing.JComponent;

import org.jbundle.thin.app.office.contact.db.Contact;
import org.jbundle.thin.app.office.contact.db.ContactCategory;
import org.jbundle.thin.base.db.Constants;
import org.jbundle.thin.base.db.Converter;
import org.jbundle.thin.base.db.FieldInfo;
import org.jbundle.thin.base.db.FieldList;
import org.jbundle.thin.base.remote.RemoteException;
import org.jbundle.thin.base.remote.RemoteSession;
import org.jbundle.thin.base.remote.RemoteTable;
import org.jbundle.thin.base.remote.RemoteTask;
import org.jbundle.thin.base.screen.BaseApplet;
import org.jbundle.thin.base.screen.JBaseScreen;
import org.jbundle.thin.base.screen.JScreen;
import org.jbundle.thin.base.screen.grid.JCellRemoteComboBox;
import org.jbundle.thin.base.screen.util.JFSCheckBox;
import org.jbundle.thin.base.screen.util.JFSImage;
import org.jbundle.thin.base.screen.util.JFSTextScroller;
import org.jbundle.thin.base.util.message.ThinMessageManager;


/**
 * Main Class for applet OrderEntry
 */
public class ContactThinScreen extends JScreen
{
    private static final long serialVersionUID = 1L;

    /**
     * OrderEntry Class Constructor.
     */
    public ContactThinScreen() {
        super();
    }

    /**
     * OrderEntry Class Constructor.
     */
    public ContactThinScreen(Object parent, Object obj) {
        this();
        this.init(parent, obj);
    }

    /**
     * The init() method is called by the AWT when an applet is first loaded or
     * reloaded. Override this method to perform whatever initialization your
     * applet needs, such as initializing data structures, loading images or
     * fonts, creating frame windows, setting the layout manager, or adding UI
     * components.
     */
    public void init(Object parent, Object obj) {

        super.init(parent, obj);
        
        ThinMessageManager.createScreenMessageListener(this.getFieldList(), this);
    }
    /**
     * Add any screen sub-panel(s) now.
     * You might want to override this to create an alternate parent screen.
     * @param parent The parent to add the new screen to.
     * @return true if success
     */
    public boolean addSubPanels(Container parent)
    {
        FieldList record = this.getFieldList();
        record.getField(Contact.NAME_SORT).setHidden(true);
        record.getField(Contact.POSTAL_CODE_SORT).setHidden(true);
        record.getField(Contact.CHANGED_ID).setHidden(true);
        return super.addSubPanels(parent);
    }
    /**
     * Cleanup.
     */
    public void free()
    {
        ThinMessageManager.freeScreenMessageListeners(this);
        
        super.free();
    }

    /**
     * Build the list of fields that make up the screen.
     */
    public FieldList buildFieldList() {
        FieldList record = new Contact(null); // If overriding class didn't set this
        return record;
    }
    /**
     * Add the screen controls to the second column of the grid.
     * Create a default component for this fieldInfo.
     * @param fieldInfo the field to create a control for.
     * @return The component.
     */
    public JComponent createScreenComponent(Converter fieldInfo)
    {
        JComponent component = null;
        if (Contact.DATE_ENTERED.equalsIgnoreCase(fieldInfo.getFieldName()))
            component = new org.jbundle.thin.base.screen.util.cal.JCalendarDualField(fieldInfo);
        if (Contact.DATE_CHANGED.equalsIgnoreCase(fieldInfo.getFieldName()))
            component = new org.jbundle.thin.base.screen.util.cal.JCalendarDualField(fieldInfo);
        if (Contact.IMAGE.equalsIgnoreCase(fieldInfo.getFieldName()))
            component = new JFSImage(null);
        if (Contact.COMMENTS.equalsIgnoreCase(fieldInfo.getFieldName()))
            component = new JFSTextScroller(null);
        if (Contact.CONTACT_CATEGORY_ID.equalsIgnoreCase(fieldInfo.getFieldName()))
        {
            BaseApplet applet = BaseApplet.getSharedInstance();
            FieldList record = new ContactCategory(this);

            RemoteTable remoteTable = null;
            try   {
                synchronized (applet.getRemoteTask())
                {   // In case this is called from another task
                    RemoteTask server = (RemoteTask)applet.getRemoteTask();
                    Map<String, Object> dbProperties = applet.getApplication().getProperties();
                    remoteTable = server.makeRemoteTable(record.getRemoteClassName(), null, null, dbProperties);
                }
            } catch (RemoteException ex)    {
                ex.printStackTrace();
            } catch (Exception ex)  {
                ex.printStackTrace();
            }
            RemoteSession remoteSession = remoteTable;

            String strDesc = fieldInfo.getFieldDesc();
            String strFieldName = ContactCategory.DESCRIPTION;
            String strComponentName = fieldInfo.getFieldName();
            boolean bCacheTable = true;
            String strIndexValue = ContactCategory.ID;
            return new JCellRemoteComboBox(applet, remoteSession, record, strDesc, strFieldName, strComponentName, bCacheTable, strIndexValue, null);
        }
        if (component == null)
            component = super.createScreenComponent(fieldInfo);
        return component;
    }
    /**
     * When a control loses focus, move the field to the data area.
     * @param e The focus event.
     */
    public void focusLost(FocusEvent e)
    {
        boolean bFirstChange = false;
        if (this.getFieldList() != null)
            if (this.getFieldList().getEditMode() == Constants.EDIT_ADD)
                if (this.getFieldList().isModified() == false)
                    bFirstChange = true;
        super.focusLost(e);
        if (bFirstChange)
        {
            m_componentNextFocus = null;
            Component component = (Component)e.getSource();
            String string = component.getName();
            FieldInfo field = this.getFieldList().getField(string);        // Get the fieldInfo for this component
            if (field != null)
                if (Contact.CODE.equals(string))
                {
                    this.getFieldList().setKeyName(Contact.CODE);
                    this.readKeyed(field);
                }
        }
    }
    /**
     * Create a grid screen for this form.
     * @param record the (optional) record for this screen.
     * @return The new grid screen.
     */
    public JBaseScreen createGridScreen(FieldList record)
    {
        return new ContactThinGridScreen(this.getParentObject(), record);
    }
}
