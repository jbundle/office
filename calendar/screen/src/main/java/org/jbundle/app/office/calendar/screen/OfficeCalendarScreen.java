/**
 * @(#)OfficeCalendarScreen.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.app.office.calendar.screen;

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
import org.jbundle.main.calendar.screen.*;
import org.jbundle.util.calendarpanel.*;
import org.jbundle.thin.base.screen.*;
import org.jbundle.base.screen.view.swing.*;
import org.jbundle.thin.base.screen.cal.popup.*;

/**
 *  OfficeCalendarScreen - .
 */
public class OfficeCalendarScreen extends CalendarEntryCalendarScreen
{
    /**
     * Default constructor.
     */
    public OfficeCalendarScreen()
    {
        super();
    }
    /**
     * Constructor.
     * @param record The main record for this screen.
     * @param itsLocation The location of this component within the parent.
     * @param parentScreen The parent screen.
     * @param fieldConverter The field this screen field is linked to.
     * @param iDisplayFieldDesc Do I display the field desc?
     * @param properties Addition properties to pass to the screen.
     */
    public OfficeCalendarScreen(Record record, ScreenLocation itsLocation, BasePanel parentScreen, Converter fieldConverter, int iDisplayFieldDesc, Map<String,Object> properties)
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
     * SetupSFields Method.
     */
    public void setupSFields()
    {
        super.setupSFields();
        if (this.getScreenFieldView().getControl() instanceof CalendarPanel)
        {   // Always
            CalendarPanel calpanel = (CalendarPanel)this.getScreenFieldView().getControl();
            BaseApplet applet = (BaseApplet)this.getAppletScreen().getScreenFieldView().getControl();
            calpanel.setPopupComponent(new JPopupPanel(applet, (VScreenField)this.getScreenFieldView()));
        }
    }

}
