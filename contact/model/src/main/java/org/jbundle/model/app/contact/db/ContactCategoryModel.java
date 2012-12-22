/**
 * @(#)ContactCategoryModel.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.model.app.contact.db;

import org.jbundle.model.db.*;

public interface ContactCategoryModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String DESCRIPTION = "Description";

    public static final String DESCRIPTION_KEY = "Description";

    public static final String CONTACT_CATEGORY_FILE = "ContactCategory";
    public static final String THIN_CLASS = "org.jbundle.thin.app.contact.db.ContactCategory";
    public static final String THICK_CLASS = "org.jbundle.app.contact.db.ContactCategory";

}
