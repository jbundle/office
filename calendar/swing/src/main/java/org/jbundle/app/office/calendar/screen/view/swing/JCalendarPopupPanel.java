/**
 * @(#)JCalendarPopupPanel.
 * Copyright © 2012 jbundle.org. All rights reserved.
 * GPL3 Open Source Software License.
 */
package org.jbundle.app.office.calendar.screen.view.swing;

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
import org.jbundle.thin.base.screen.*;
import org.jbundle.main.calendar.db.*;
import org.jbundle.thin.base.screen.cal.popup.*;
import java.awt.event.*;

/**
 *  JCalendarPopupPanel - .
 */
public class JCalendarPopupPanel extends JBasePopupPanel
{
    /**
     * Default constructor.
     */
    public JCalendarPopupPanel()
    {
        super();
    }
    /**
     * JCalendarPopupPanel Method.
     */
    public JCalendarPopupPanel(BaseApplet applet, ActionListener actionListener)
    {
        this();
        this.init(applet, actionListener);
    }
    /**
     * Initialize class fields.
     */
    public void init(BaseApplet applet, ActionListener actionListener)
    {
        super.init(applet, actionListener);
    }
    /**
     * AddComponents Method.
     */
    public void addComponents(BaseApplet applet)
    {
        super.addComponents(applet);
        
        this.add(this.createComponentButton(CalendarEntryTypeField.APPOINTMENT, applet));
        this.add(this.createComponentButton(CalendarEntryTypeField.ANNIVERSARY, applet));
    }

}
