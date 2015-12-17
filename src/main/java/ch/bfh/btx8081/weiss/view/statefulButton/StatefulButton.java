package ch.bfh.btx8081.weiss.view.statefulButton;

import java.io.Serializable;
import java.lang.reflect.Method;

import com.vaadin.server.Resource;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.util.ReflectTools;

public class StatefulButton extends Button {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6038809609637610982L;

	private ButtonState state;

	
	
	
	public StatefulButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatefulButton(Resource icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public StatefulButton(String caption, ClickListener listener) {
		super(caption, listener);
		// TODO Auto-generated constructor stub
	}

	public StatefulButton(String caption, Resource icon) {
		super(caption, icon);
		// TODO Auto-generated constructor stub
	}

	public StatefulButton(String caption) {
		super(caption);
		// TODO Auto-generated constructor stub
	}

	public void setButtonState(ButtonState state) {
		this.state = state;
	}

	public ButtonState getButtonState() {
		return state;
	}
	
	public static class StatefulClickEvent extends Component.Event {

        /**
		 * 
		 */
		private static final long serialVersionUID = 3794692770176745276L;
		private final MouseEventDetails details;

        /**
         * New instance of text change event.
         * 
         * @param source
         *            the Source of the event.
         */
        public StatefulClickEvent(Component source) {
            super(source);
            details = null;
        }

        /**
         * Constructor with mouse details
         * 
         * @param source
         *            The source where the click took place
         * @param details
         *            Details about the mouse click
         */
        public StatefulClickEvent(Component source, MouseEventDetails details) {
            super(source);
            this.details = details;
        }

        /**
         * Gets the Button where the event occurred.
         * 
         * @return the Source of the event.
         */
        public StatefulButton getButton() {
            return (StatefulButton) getSource();
        }

        /**
         * Returns the mouse position (x coordinate) when the click took place.
         * The position is relative to the browser client area.
         * 
         * @return The mouse cursor x position or -1 if unknown
         */
        public int getClientX() {
            if (null != details) {
                return details.getClientX();
            } else {
                return -1;
            }
        }

        /**
         * Returns the mouse position (y coordinate) when the click took place.
         * The position is relative to the browser client area.
         * 
         * @return The mouse cursor y position or -1 if unknown
         */
        public int getClientY() {
            if (null != details) {
                return details.getClientY();
            } else {
                return -1;
            }
        }

        /**
         * Returns the relative mouse position (x coordinate) when the click
         * took place. The position is relative to the clicked component.
         * 
         * @return The mouse cursor x position relative to the clicked layout
         *         component or -1 if no x coordinate available
         */
        public int getRelativeX() {
            if (null != details) {
                return details.getRelativeX();
            } else {
                return -1;
            }
        }

        /**
         * Returns the relative mouse position (y coordinate) when the click
         * took place. The position is relative to the clicked component.
         * 
         * @return The mouse cursor y position relative to the clicked layout
         *         component or -1 if no y coordinate available
         */
        public int getRelativeY() {
            if (null != details) {
                return details.getRelativeY();
            } else {
                return -1;
            }
        }

        /**
         * Checks if the Alt key was down when the mouse event took place.
         * 
         * @return true if Alt was down when the event occured, false otherwise
         *         or if unknown
         */
        public boolean isAltKey() {
            if (null != details) {
                return details.isAltKey();
            } else {
                return false;
            }
        }

        /**
         * Checks if the Ctrl key was down when the mouse event took place.
         * 
         * @return true if Ctrl was pressed when the event occured, false
         *         otherwise or if unknown
         */
        public boolean isCtrlKey() {
            if (null != details) {
                return details.isCtrlKey();
            } else {
                return false;
            }
        }

        /**
         * Checks if the Meta key was down when the mouse event took place.
         * 
         * @return true if Meta was pressed when the event occured, false
         *         otherwise or if unknown
         */
        public boolean isMetaKey() {
            if (null != details) {
                return details.isMetaKey();
            } else {
                return false;
            }
        }

        /**
         * Checks if the Shift key was down when the mouse event took place.
         * 
         * @return true if Shift was pressed when the event occured, false
         *         otherwise or if unknown
         */
        public boolean isShiftKey() {
            if (null != details) {
                return details.isShiftKey();
            } else {
                return false;
            }
        }
    }

    /**
     * Interface for listening for a {@link ClickEvent} fired by a
     * {@link Component}.
     * 
     * @author Vaadin Ltd.
     * @since 3.0
     */
    public interface StatefulClickListener extends Serializable {

        public static final Method BUTTON_CLICK_METHOD = ReflectTools
                .findMethod(StatefulClickListener.class, "buttonClick",
                        StatefulClickEvent.class);

        /**
         * Called when a {@link Button} has been clicked. A reference to the
         * button is given by {@link ClickEvent#getButton()}.
         * 
         * @param event
         *            An event containing information about the click.
         */
        public void buttonClick(StatefulClickEvent event);

    }
    
    public void addStatefulClickListener(StatefulClickListener listener) {
        addListener(StatefulClickEvent.class, listener,
        		StatefulClickListener.BUTTON_CLICK_METHOD);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #addClickListener(ClickListener)}
     **/
    @Deprecated
    public void addStatefulListener(StatefulClickListener listener) {
        addStatefulClickListener(listener);
    }

    /**
     * Removes the button click listener.
     * 
     * @param listener
     *            the Listener to be removed.
     */
    public void removeStatefulClickListener(StatefulClickListener listener) {
        removeListener(StatefulClickEvent.class, listener,
        		StatefulClickListener.BUTTON_CLICK_METHOD);
    }

    /**
     * @deprecated As of 7.0, replaced by
     *             {@link #removeClickListener(ClickListener)}
     **/
    @Deprecated
    public void removeStatefulListener(StatefulClickListener listener) {
        removeStatefulClickListener(listener);
    }

    /**
     * Simulates a button click, notifying all server-side listeners.
     * 
     * No action is taken is the button is disabled.
     */
    public void click() {
        if (isEnabled() && !isReadOnly()) {
            fireClick();
        }
    }

    @Override
    protected void fireClick() {
        fireEvent(new StatefulButton.StatefulClickEvent(this));
    }

    @Override
    protected void fireClick(MouseEventDetails details) {
        fireEvent(new StatefulButton.StatefulClickEvent(this, details));
    }
}