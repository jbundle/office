/**
 * @(#)ContactScreenRecord.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.app.office.screen;

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
import org.jbundle.app.office.db.*;

/**
 *  ContactScreenRecord - .
 */
public class ContactScreenRecord extends ScreenRecord
{
    private static final long serialVersionUID = 1L;

    public static final String PROFILE_KEY = "ProfileKey";
    public static final String NAME_SORT = "NameSort";
    public static final String POSTAL_CODE_SORT = "PostalCodeSort";
    public static final String CONTACT_CATEGORY_ID = "ContactCategoryID";
    /**
     * Default constructor.
     */
    public ContactScreenRecord()
    {
        super();
    }
    /**
     * Constructor.
     */
    public ContactScreenRecord(RecordOwner screen)
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

    public static final String CONTACT_SCREEN_RECORD_FILE = null; // Screen field
    /**
     * Add this field in the Record's field sequence.
     */
    public BaseField setupField(int iFieldSeq)
    {
        BaseField field = null;
        if (iFieldSeq == 0)
            field = new ShortField(this, PROFILE_KEY, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (iFieldSeq == 1)
            field = new StringField(this, NAME_SORT, 15, null, null);
        if (iFieldSeq == 2)
            field = new StringField(this, POSTAL_CODE_SORT, 10, null, null);
        if (iFieldSeq == 3)
            field = new ContactCategoryFilter(this, CONTACT_CATEGORY_ID, Constants.DEFAULT_FIELD_LENGTH, null, null);
        if (field == null)
            field = super.setupField(iFieldSeq);
        return field;
    }
    /**
     * Add all standard file & field behaviors.
     * Override this to add record listeners and filters.
     */
    public void addListeners()
    {
        super.addListeners();
        FieldToUpperHandler upper = new FieldToUpperHandler(null);
        this.getField(ContactScreenRecord.NAME_SORT).addListener(upper);
        CheckForTheHandler the = new CheckForTheHandler(null);
        this.getField(ContactScreenRecord.NAME_SORT).addListener(the);
    }

}
