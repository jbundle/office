/**
 * @(#)ContactGridScreen.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.app.office.contact.screen;

import java.awt.*;
import java.util.*;

import org.jbundle.base.db.*;
import org.jbundle.thin.base.util.*;
import org.jbundle.thin.base.db.*;
import org.jbundle.base.db.event.*;
import org.jbundle.base.db.filter.*;
import org.jbundle.base.field.*;
import org.jbundle.base.field.convert.*;
import org.jbundle.base.field.event.*;
import org.jbundle.base.screen.model.*;
import org.jbundle.base.screen.model.util.*;
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import org.jbundle.app.office.contact.db.*;

/**
 *  ContactGridScreen - .
 */
public class ContactGridScreen extends GridScreen
{
    /**
     * Default constructor.
     */
    public ContactGridScreen()
    {
        super();
    }
    /**
     * Constructor.
     * @param record The main record for this screen.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?.
     */
    public ContactGridScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        this();
        this.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Initialize class fields.
     */
    public void init(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
    {
        super.init(record, itsLocation, parentScreen, fieldConverter, iDisplayFieldDesc, properties);
    }
    /**
     * Override this to open the main file.
     * <p />You should pass this record owner to the new main file (ie., new MyNewTable(thisRecordOwner)).
     * @return The new record.
     */
    public Record openMainRecord()
    {
        return new Contact(this);
    }
    /**
     * Add the screen fields.
     * Override this to create (and return) the screen record for this recordowner.
     * @return The screen record.
     */
    public Record addScreenRecord()
    {
        return new ContactScreenRecord(this);
    }
    /**
     * Add all the screen listeners.
     */
    public void addListeners()
    {
        super.addListeners();
        Record recContact = this.getMainRecord();
        recContact.setKeyArea(Contact.NAME_SORT_KEY);
        SortOrderHandler keyBehavior = new SortOrderHandler(this);
        keyBehavior.setGridTable(Contact.NAME_SORT_KEY, recContact, 0);
        keyBehavior.setGridTable(Contact.CONTACT_KEY, recContact, 1);
        keyBehavior.setGridTable(null, recContact, 2);
        keyBehavior.setGridTable(Contact.POSTAL_CODE_SORT_KEY, recContact, 3);
        keyBehavior.setGridTable(null, recContact, 4);
        keyBehavior.setGridTable(null, recContact, 5);
        keyBehavior.setGridTable(null, recContact, 6);
        this.getScreenRecord().getField(ContactScreenRecord.PROFILE_KEY).addListener(keyBehavior);
        
        recContact.addListener(new ExtractRangeFilter(Contact.POSTAL_CODE_SORT, this.getScreenRecord().getField(ContactScreenRecord.POSTAL_CODE_SORT)));
        recContact.addListener(new ExtractRangeFilter(Contact.NAME_SORT, this.getScreenRecord().getField(ContactScreenRecord.NAME_SORT)));
        recContact.addListener(new CompareFileFilter(Contact.CONTACT_CATEGORY_ID, this.getScreenRecord().getField(ContactScreenRecord.CONTACT_CATEGORY_ID), "=", null, true));
        
        this.getScreenRecord().getField(ContactScreenRecord.NAME_SORT).addListener(new FieldReSelectHandler(this));
        this.getScreenRecord().getField(ContactScreenRecord.POSTAL_CODE_SORT).addListener(new FieldReSelectHandler(this));
        this.getScreenRecord().getField(ContactScreenRecord.CONTACT_CATEGORY_ID).addListener(new FieldReSelectHandler(this));
    }
    /**
     * SetupSFields Method.
     */
    public void setupSFields()
    {
        this.getRecord(Contact.CONTACT_FILE).getField(Contact.NAME).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Contact.CONTACT_FILE).getField(Contact.CONTACT).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Contact.CONTACT_FILE).getField(Contact.CITY_OR_TOWN).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Contact.CONTACT_FILE).getField(Contact.POSTAL_CODE).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
        this.getRecord(Contact.CONTACT_FILE).getField(Contact.EMAIL).setupDefaultView(this.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.ANCHOR_DEFAULT), this, ScreenConstants.DEFAULT_DISPLAY);
    }
    /**
     * Add button(s) to the toolbar.
     */
    public void addToolbarButtons(ToolScreen toolScreen)
    {
        new SCannedBox(toolScreen.getNextLocation(ScreenConstants.NEXT_LOGICAL, ScreenConstants.SET_ANCHOR), toolScreen, null, ScreenConstants.DEFAULT_DISPLAY, null, MenuConstants.FORMDETAIL, MenuConstants.FORMDETAIL, MenuConstants.FORMDETAIL, null);
        toolScreen.getScreenRecord().getField(ContactScreenRecord.NAME_SORT).setupDefaultView(toolScreen.getNextLocation(ScreenConstants.RIGHT_WITH_DESC, ScreenConstants.SET_ANCHOR), toolScreen, ScreenConstants.DEFAULT_DISPLAY);
        toolScreen.getScreenRecord().getField(ContactScreenRecord.POSTAL_CODE_SORT).setupDefaultView(toolScreen.getNextLocation(ScreenConstants.NEXT_INPUT_LOCATION, ScreenConstants.SET_ANCHOR), toolScreen, ScreenConstants.DEFAULT_DISPLAY);
        toolScreen.getScreenRecord().getField(ContactScreenRecord.CONTACT_CATEGORY_ID).setupDefaultView(toolScreen.getNextLocation(ScreenConstants.RIGHT_WITH_DESC, ScreenConstants.SET_ANCHOR), toolScreen, ScreenConstants.DEFAULT_DISPLAY);
    }

}
