/**
 * @(#)AddressBookModel.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.app.office.sample.addressbook.model.db;

import org.jbundle.model.db.*;

public interface AddressBookModel extends Rec
{

    //public static final String ID = ID;
    //public static final String LAST_CHANGED = LAST_CHANGED;
    //public static final String DELETED = DELETED;
    public static final String NAME = "Name";
    public static final String ADDRESS = "Address";

    public static final String ADDRESS_BOOK_FILE = "AddressBook";
    public static final String THIN_CLASS = "org.jbundle.app.office.sample.addressbook.thin.db.AddressBook";
    public static final String THICK_CLASS = "org.jbundle.app.office.sample.addressbook.db.AddressBook";

}
