/**
 * @(#)Contact.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.app.office.db;

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
import org.jbundle.base.model.*;
import org.jbundle.base.util.*;
import org.jbundle.model.*;
import org.jbundle.model.db.*;
import org.jbundle.model.screen.*;
import org.jbundle.main.db.*;
import org.jbundle.model.app.office.db.*;

/**
 *  Contact - .
 */
public class Contact extends Company
     implements ContactModel
{
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public Contact()
    {
        super();
    }
    /**
     * Constructor.
     */
    public Contact(RecordOwner screen)
    {
        this();
        this.init(screen);
    }
    /**
     * Initialize class fields.
     */
    public void init(RecordOwner screen)
    {
        super.init(screen);
    }
    /**
     * Get the table name.
     */
    public String getTableNames(boolean bAddQuotes)
    {
        return (m_tableName == null) ? Record.formatTableNames(CONTACT_FILE, bAddQuotes) : super.getTableNames(bAddQuotes);
    }
    /**
     * Get the name of a single record.
     */
    public String getRecordName()
    {
        return "Contact";
    }
    /**
     * Get the Database Name.
     */
    public String getDatabaseName()
    {
        return "app";
    }
    /**
     * Is this a local (vs remote) file?.
     */
    public int getDatabaseType()
    {
        return DBConstants.REMOTE | DBConstants.USER_DATA;
    }
    /**
     * Make a default screen.
     */
    public ScreenParent makeScreen(ScreenLoc itsLocation, ComponentParent parentScreen, int iDocMode, Map<String,Object> properties)
    {
        ScreenParent screen = null;
        if ((iDocMode & ScreenConstants.MAINT_MODE) == ScreenConstants.MAINT_MODE)
            screen = Record.makeNewScreen(CONTACT_SCREEN_CLASS, itsLocation, parentScreen, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties, this, true);
        else if ((iDocMode & ScreenConstants.DISPLAY_MODE) == ScreenConstants.DISPLAY_MODE)
            screen = Record.makeNewScreen(CONTACT_GRID_SCREEN_CLASS, itsLocation, parentScreen, iDocMode | ScreenConstants.DONT_DISPLAY_FIELD_DESC, properties, this, true);
        else
            screen = super.makeScreen(itsLocation, parentScreen, iDocMode, properties);
        return screen;
    }
    /**
     * Add this field in the Record's field sequence.
     */
    public BaseField setupField(int iFieldSeq)
    {
        BaseField field = null;
        //if (iFieldSeq == 0)
        //{
        //  field = new CounterField(this, ID, 8, null, null);
        //  field.setHidden(true);
        //}
        //if (iFieldSeq == 1)
        //{
        //  field = new RecordChangedField(this, LAST_CHANGED, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //  field.setHidden(true);
        //}
        //if (iFieldSeq == 2)
        //{
        //  field = new BooleanField(this, DELETED, Constants.DEFAULT_FIELD_LENGTH, null, new Boolean(false));
        //  field.setHidden(true);
        //}
        //if (iFieldSeq == 3)
        //  field = new StringField(this, CODE, 16, null, null);
        //if (iFieldSeq == 4)
        //  field = new StringField(this, NAME, 30, null, null);
        //if (iFieldSeq == 5)
        //  field = new StringField(this, ADDRESS_LINE_1, 40, null, null);
        //if (iFieldSeq == 6)
        //  field = new StringField(this, ADDRESS_LINE_2, 40, null, null);
        //if (iFieldSeq == 7)
        //  field = new StringField(this, CITY_OR_TOWN, 15, null, null);
        //if (iFieldSeq == 8)
        //  field = new StringField(this, STATE_OR_REGION, 15, null, null);
        //if (iFieldSeq == 9)
        //  field = new StringField(this, POSTAL_CODE, 10, null, null);
        //if (iFieldSeq == 10)
        //  field = new StringField(this, COUNTRY, 15, null, null);
        //if (iFieldSeq == 11)
        //  field = new PhoneField(this, TEL, 24, null, null);
        //if (iFieldSeq == 12)
        //  field = new FaxField(this, FAX, 24, null, null);
        //if (iFieldSeq == 13)
        //  field = new EMailField(this, EMAIL, 40, null, null);
        //if (iFieldSeq == 14)
        //  field = new URLField(this, WEB, 60, null, null);
        //if (iFieldSeq == 15)
        //  field = new Contact_DateEntered(this, DATE_ENTERED, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == 16)
        //  field = new DateField(this, DATE_CHANGED, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == 17)
        //  field = new ReferenceField(this, CHANGED_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == 18)
        //  field = new MemoField(this, COMMENTS, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == 19)
        //  field = new UserField(this, USER_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        //if (iFieldSeq == 20)
        //  field = new StringField(this, PASSWORD, 16, null, null);
        //if (iFieldSeq == 21)
        //  field = new StringField(this, NAME_SORT, 6, null, null);
        //if (iFieldSeq == 22)
        //  field = new StringField(this, POSTAL_CODE_SORT, 5, null, null);
        //if (iFieldSeq == 23)
        //  field = new StringField(this, CONTACT, 30, null, null);
        if (iFieldSeq == 24)
            field = new StringField(this, TITLE, 30, null, null);
        if (iFieldSeq == 25)
            field = new StringField(this, HOME_TEL, 30, null, null);
        if (iFieldSeq == 26)
            field = new StringField(this, HOME_EMAIL, 100, null, null);
        if (iFieldSeq == 27)
            field = new ContactCategoryFilter(this, CONTACT_CATEGORY_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (field == null)
            field = super.setupField(iFieldSeq);
        return field;
    }
    /**
     * Add this key area description to the Record.
     */
    public KeyArea setupKey(int iKeyArea)
    {
        KeyArea keyArea = null;
        if (iKeyArea == 0)
        {
            keyArea = this.makeIndex(DBConstants.UNIQUE, ID_KEY);
            keyArea.addKeyField(ID, DBConstants.ASCENDING);
        }
        if (iKeyArea == 1)
        {
            keyArea = this.makeIndex(DBConstants.NOT_UNIQUE, NAME_SORT_KEY);
            keyArea.addKeyField(NAME_SORT, DBConstants.ASCENDING);
        }
        if (iKeyArea == 2)
        {
            keyArea = this.makeIndex(DBConstants.NOT_UNIQUE, POSTAL_CODE_SORT_KEY);
            keyArea.addKeyField(POSTAL_CODE_SORT, DBConstants.ASCENDING);
        }
        if (iKeyArea == 3)
        {
            keyArea = this.makeIndex(DBConstants.NOT_UNIQUE, CONTACT_KEY);
            keyArea.addKeyField(CONTACT, DBConstants.ASCENDING);
        }
        if (keyArea == null)
            keyArea = super.setupKey(iKeyArea);     
        return keyArea;
    }
    /**
     * AddMasterListeners Method.
     */
    public void addMasterListeners()
    {
        super.addMasterListeners();
        
        CopyFieldHandler copyName = (CopyFieldHandler)this.getField(Contact.NAME).getListener(CopyFieldHandler.class.getName());
        this.getField(Contact.NAME).removeListener(copyName, true);
        copyName = new CopyFieldHandler(Contact.NAME_SORT)
        {
            public int moveIt(boolean bDisplayOption, int iMoveMode)
            {
                BaseField fldContact = getOwner().getRecord().getField(Contact.CONTACT);
                BaseField fldName = getOwner();
                if ((fldName.isNull()) && (!fldContact.isNull()))
                {
                    return fldContact.handleFieldChanged(bDisplayOption, iMoveMode);
                }
                return super.moveIt(bDisplayOption, iMoveMode);
            }
        };
        this.getField(Contact.NAME).addListener(copyName);
        
        CopyFieldHandler copyLast = new CopyLastHandler(Contact.NAME_SORT)
        {
            public int moveIt(boolean bDisplayOption, int iMoveMode)
            {
                BaseField fldName = getOwner().getRecord().getField(Contact.NAME);
                if (!fldName.isNull())
                    return DBConstants.NORMAL_RETURN;   // Don't wipe the name
                return super.moveIt(bDisplayOption, iMoveMode);
            }
        };
        this.getField(Contact.CONTACT).addListener(copyLast);
    }

}
