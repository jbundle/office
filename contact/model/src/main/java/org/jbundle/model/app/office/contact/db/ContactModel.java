/**
 * @(#)ContactModel.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.model.app.office.contact.db;

import org.jbundle.model.main.db.*;

public interface ContactModel extends CompanyModel
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    //public static final String CODE = CODE;
    //public static final String NAME = NAME;
    //public static final String ADDRESS_LINE_1 = ADDRESS_LINE_1;
    //public static final String ADDRESS_LINE_2 = ADDRESS_LINE_2;
    //public static final String CITY_OR_TOWN = CITY_OR_TOWN;
    //public static final String STATE_OR_REGION = STATE_OR_REGION;
    //public static final String POSTAL_CODE = POSTAL_CODE;
    //public static final String COUNTRY = COUNTRY;
    //public static final String TEL = TEL;
    //public static final String FAX = FAX;
    //public static final String EMAIL = EMAIL;
    //public static final String WEB = WEB;
    //public static final String DATE_ENTERED = DATE_ENTERED;
    //public static final String DATE_CHANGED = DATE_CHANGED;
    //public static final String CHANGED_ID = CHANGED_ID;
    //public static final String COMMENTS = COMMENTS;
    //public static final String USER_ID = USER_ID;
    //public static final String PASSWORD = PASSWORD;
    //public static final String NAME_SORT = NAME_SORT;
    //public static final String POSTAL_CODE_SORT = POSTAL_CODE_SORT;
    //public static final String CONTACT = CONTACT;
    public static final String TITLE = "Title";
    public static final String HOME_TEL = "HomeTel";
    public static final String HOME_EMAIL = "HomeEmail";
    public static final String CONTACT_CATEGORY_ID = "ContactCategoryID";
    public static final String IMAGE = "Image";

    public static final String NAME_SORT_KEY = "NameSort";

    public static final String POSTAL_CODE_SORT_KEY = "PostalCodeSort";
    public static final String CONTACT_SCREEN_CLASS = "org.jbundle.app.office.contact.screen.ContactScreen";
    public static final String CONTACT_GRID_SCREEN_CLASS = "org.jbundle.app.office.contact.screen.ContactGridScreen";

    public static final String CONTACT_FILE = "Contact";
    public static final String THIN_CLASS = "org.jbundle.thin.app.office.contact.db.Contact";
    public static final String THICK_CLASS = "org.jbundle.app.office.contact.db.Contact";

}
