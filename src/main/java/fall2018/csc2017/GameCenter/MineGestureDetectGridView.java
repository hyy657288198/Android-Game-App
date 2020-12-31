package fall2018.csc2017.GameCenter;
/*
Adapted from:
https://github.com/DaveNOTDavid/sample-puzzle/blob/master/app/src/main/java/com/davenotdavid/samplepuzzle/GestureDetectGridView.java

This extension of GridView contains built in logic for handling swipes between buttons
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.GridView;

import java.io.Serializable;

/**
 * The mine game's gesture detect grid view.
 */
public class MineGestureDetectGridView extends GridView implements Serializable {
    /**
     * The minimum swipe distance.
     */
    public static final int SWIPE_MIN_DISTANCE = 100;
    /**
     * The gesture detector.
     */
    private GestureDetector gDetector;
    /**
     * The movement controller of mine game.
     */
    private MineMovementController mineMovementController;
    /**
     * The mark of whether the matrix's fling is confirmed.
     */
    private boolean mFlingConfirmed = false;
    /**
     * The touched x coordinate.
     */
    private float mTouchX;
    /**
     * The touched y coordinate.
     */
    private float mTouchY;


    /**
     * The first constructor of Mine Gesture Detect Grid View.
     *
     * @param context the context.
     */
    public MineGestureDetectGridView(Context context) {
        super(context);
        init(context);
    }

    /**
     * The second constructor of Mine Gesture Detect Grid View.
     *
     * @param context the context.
     * @param attrs   the attributes set.
     */
    public MineGestureDetectGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * The third constructor of Mine Gesture Detect Grid View.
     *
     * @param context      the context.
     * @param attrs        the attributes set.
     * @param defStyleAttr the style attribute set.
     */
    public MineGestureDetectGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * The initialization of mine movement controller.
     *
     * @param context the context.
     */
    private void init(final Context context) {
        mineMovementController = new MineMovementController(context);
        gDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            /**
             * The confirm of whether tapped or not.
             *
             * @param event the tap event.
             * @return whether the user tapped or not.(execute other motions or not)
             */
            @Override
            public boolean onSingleTapConfirmed(MotionEvent event) {
                int position = MineGestureDetectGridView.this.pointToPosition
                        (Math.round(event.getX()), Math.round(event.getY()));

                mineMovementController.processTapMovement(context, position);
                return false;
            }

            /**
             * The double tap event.
             * @param event the double tap event.
             * @return whether the user double tapped.(execute other motions or not)
             */
            @Override
            public boolean onDoubleTap(MotionEvent event) {
                int position = MineGestureDetectGridView.this.pointToPosition
                        (Math.round(event.getX()), Math.round(event.getY()));

                mineMovementController.processDoubleTapMovement(position);
                return false;
            }

            /**
             * Whether there is a down event.
             *
             * @param event the event.
             * @return whether the event is a down event.(execute other motions or not)
             */
            @Override
            public boolean onDown(MotionEvent event) {
                return false;
            }

        });
    }

    /**
     * Whether the event is a intercept touch event.
     *
     * @param ev the event.
     * @return whether the event is a intercept touch event.
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        gDetector.onTouchEvent(ev);

        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mFlingConfirmed = false;
        } else if (action == MotionEvent.ACTION_DOWN) {
            mTouchX = ev.getX();
            mTouchY = ev.getY();
        } else {

            if (mFlingConfirmed) {
                return true;
            }

            float dX = (Math.abs(ev.getX() - mTouchX));
            float dY = (Math.abs(ev.getY() - mTouchY));
            if ((dX > SWIPE_MIN_DISTANCE) || (dY > SWIPE_MIN_DISTANCE)) {
                mFlingConfirmed = true;
                return true;
            }
        }

        return super.onInterceptTouchEvent(ev);
    }

    /**
     * Whether the user touched or not.
     *
     * @param ev the event.
     * @return whether the event is a touch event.
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return gDetector.onTouchEvent(ev);
    }

    /**
     * Set the mine manager for the controller.
     *
     * @param MineManager the mine manager.
     */
    public void setMineManager(MineManager MineManager) {
        mineMovementController.setMineManager(MineManager);
    }
}