package org.billing.service;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridLayout.Spec;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private static final int MINIMUM_COLUMNS = 3;
	
	private int numberOfSeats = 4;
	private boolean visible = false;
	private List< View > seatsViews = new ArrayList<View>();
	
	private View setSeatsOnView( int seats ) { 
        GridLayout mainView = (GridLayout) findViewById( R.id.mainLayout );
        
        for ( View seat : seatsViews ) {
        	mainView.removeView( seat );
        }
        
        int seatsInRow = ( seats + 1 ) / 2;
		mainView.setColumnCount( seatsInRow );
        for ( int column = 0; column < seatsInRow; ++column ) {
        	int row = 0;
        	int gravity = Gravity.TOP | getHorizontalGravity( column, seatsInRow );
	        addSeatToView(mainView, column, row, gravity); 
        }
        if ( seats % 2 != 0 ) { 
        	--seatsInRow;
        }
        for ( int column = 0; column < seatsInRow; ++column ) {
        	int row = 2;
        	int gravity = Gravity.BOTTOM | getHorizontalGravity( column, seatsInRow );
	        addSeatToView(mainView, column, row, gravity); 
        }
        this.numberOfSeats = seats;
		setContentView( mainView );
        
		return mainView;
	}

	private int getHorizontalGravity(int column, int seatsInRow) {
    	if ( column == 0 ) { 
    		return Gravity.CENTER;
    	}
    	else if ( column == seatsInRow - 1 ) { 
    		return Gravity.RIGHT;
    	}
    	else { 
    		return Gravity.LEFT;
    	}
	}

	private void addSeatToView(GridLayout mainView, int column, int row, int gravity) {
		ImageView imageView = new ImageView( this );
		imageView.setImageResource( R.drawable.chair_48 );
		imageView.setPadding(30, 0, 0, 0);
		Spec rowSpec = GridLayout.spec(row);
		Spec colSpec = GridLayout.spec(column);
		GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams( rowSpec, colSpec );
		imageView.setLayoutParams( layoutParams );
		layoutParams.setGravity(gravity);
		mainView.addView( imageView );
		
		seatsViews.add( imageView );
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.main );
        
        setSeatsOnView( this.numberOfSeats );        
        
        ImageButton toggleButton = (ImageButton) findViewById(R.id.toggleNumberOfSeatsButton);
        toggleButton.setOnClickListener( OnToggleButtonClickListener );
        
        findViewById( R.id.numberOfSeatsSetButton ).setOnClickListener( OnNumberOfSeatsSet );
    }

	private void setNumberOfSeatsVisibility(boolean visible) {
		int visibility = visible ? View.VISIBLE : View.INVISIBLE;
		int imageButtonVisibility = !visible ? View.VISIBLE : View.INVISIBLE;
		findViewById( R.id.numberOfSeatsLabel ).setVisibility( visibility );
		findViewById( R.id.numberOfSeatsText ).setVisibility( visibility );
		findViewById( R.id.numberOfSeatsSetButton ).setVisibility( visibility );
		findViewById( R.id.toggleNumberOfSeatsButton ).setVisibility( imageButtonVisibility );
	}
    
	private final OnClickListener OnToggleButtonClickListener = new OnClickListener() {
		
		public void onClick(View v) {
			visible = !visible;
			setNumberOfSeatsVisibility( visible );
		}

	};
    
	private OnClickListener OnNumberOfSeatsSet = new OnClickListener() {
		
		public void onClick(View v) {
			EditText editText = (EditText) findViewById( R.id.numberOfSeatsText );
			int number = Integer.parseInt( editText.getText().toString() );
			if ( number != MainActivity.this.numberOfSeats ) {
				setSeatsOnView(number);
			}
			visible = !visible;
			setNumberOfSeatsVisibility( visible );
		}
	};
	
}