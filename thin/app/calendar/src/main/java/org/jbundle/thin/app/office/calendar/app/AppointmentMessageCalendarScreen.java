/*
 * Copyright © 2012 jbundle.org. All rights reserved.
 */
package org.jbundle.thin.app.office.calendar.app;

/**
 * OrderEntry.java:   Applet
 *  Copyright � 1997 jbundle.org. All rights reserved.
 *  
 *  @author Don Corley don@tourgeek.com
 *  @version 1.0.0.
 */
import java.util.Properties;

import org.jbundle.model.message.MessageManager;
import org.jbundle.model.message.MessageReceiver;
import org.jbundle.thin.base.db.FieldList;
import org.jbundle.thin.base.db.client.RemoteFieldTable;
import org.jbundle.thin.base.message.BaseMessageFilter;
import org.jbundle.thin.base.message.BaseMessageManager;
import org.jbundle.thin.base.message.JMessageListener;
import org.jbundle.thin.base.message.MessageConstants;
import org.jbundle.thin.base.message.event.ModelMessageHandler;
import org.jbundle.thin.base.message.session.ClientSessionMessageFilter;
import org.jbundle.thin.base.remote.RemoteSession;
import org.jbundle.thin.base.screen.cal.grid.CalendarThinTableModel;
import org.jbundle.thin.base.util.message.ThinMessageManager;


/**
 * A Basic order entry screen.
 * This screen is made of a panel with a GridBagLayout. Labels in the first column, aligned right.
 * Data fields in the second column aligned left.
 */
public class AppointmentMessageCalendarScreen extends AppointmentCalendarScreen
{
	private static final long serialVersionUID = 1L;

	/**
     *  JBaseScreen Class Constructor.
     */
    public AppointmentMessageCalendarScreen()
    {
        super();
    }
    /**
     *  JBaseScreen Class Constructor.
     * Typically, you pass the BaseApplet as the parent, and the record or GridTableModel as the parent.
     */
    public AppointmentMessageCalendarScreen(Object parent, Object record)
    {
        this();
        this.init(parent, record);
    }
    /**
     * Initialize this class.
     * @param parent Typically, you pass the BaseApplet as the parent.
     * @param record and the record or GridTableModel as the parent.
     */
    public void init(Object parent, Object record)
    {
        super.init(parent, record);
    }
    /**
     * Free the sub=components.
     */
    public void free()
    {
        super.free();
    }
    /**
     * Build the list of fields that make up the screen.
     * Override this to create a new record.
     * @return The fieldlist for this screen.
     */
    public FieldList buildFieldList()
    {
        AppointmentCalendarItem record = new AppointmentCalendarItem(this);
//x        Appointment record = new Appointment(this);
        RemoteSession remoteSession = this.getBaseApplet().makeRemoteSession(null, ".main.calendar.remote.CalendarModelSession");
        this.getBaseApplet().linkRemoteSessionTable(remoteSession, record, true);
        return record;
    }
}
