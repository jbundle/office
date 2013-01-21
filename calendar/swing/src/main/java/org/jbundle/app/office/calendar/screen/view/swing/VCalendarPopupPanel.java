/**
 * @(#)VCalendarPopupPanel.
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
import org.jbundle.base.screen.view.swing.*;
import org.jbundle.base.screen.model.*;
import org.jbundle.util.calendarpanel.*;
import org.jbundle.thin.base.screen.*;
import java.awt.*;

/**
 *  VCalendarPopupPanel - .
 */
public class VCalendarPopupPanel extends VScreenField
{
    /**
     * Default constructor.
     */
    public VCalendarPopupPanel()
    {
        super();
    }
    /**
     * VCalendarPopupPanel Method.
     */
    public VCalendarPopupPanel(ScreenField model, boolean bEditableControl)
    {
        this();
        this.init(model, bEditableControl);
    }
    /**
     * Init Method.
     */
    public void init(ScreenComponent model, boolean bEditableControl)
    {
        super.init(model, bEditableControl);
        BaseScreen parent = (BaseScreen)model.getParentScreen();
        CalendarPanel calpanel = (CalendarPanel)parent.getControl();
        BaseApplet applet = (BaseApplet)parent.getAppletScreen().getScreenFieldView().getControl();
        calpanel.setPopupComponent(new JCalendarPopupPanel(applet, (VScreenField)parent.getScreenFieldView()));
    }
    /**
     * SetupControl Method.
     */
    public Component setupControl(boolean bEditableControl)
    {
        Component control = null;
        return control;
    }

}
