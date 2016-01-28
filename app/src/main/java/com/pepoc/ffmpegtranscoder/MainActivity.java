
package com.pepoc.ffmpegtranscoder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText cmdEdittext= (EditText) this.findViewById(R.id.editText_cmd);
        Button startButton= (Button) this.findViewById(R.id.button_start);
        
        startButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				String cmdline=cmdEdittext.getText().toString();
		        String[] argv=cmdline.split(" ");
		        Integer argc=argv.length;
		        ffmpegcore(argc,argv);
			}
		});
    }

    public native int ffmpegcore(int argc,String[] argv);
    static{
    	System.loadLibrary("avutil-54");
    	System.loadLibrary("swresample-1");
    	System.loadLibrary("avcodec-56");
    	System.loadLibrary("avformat-56");
    	System.loadLibrary("swscale-3");
    	System.loadLibrary("postproc-53");
    	System.loadLibrary("avfilter-5");
    	System.loadLibrary("avdevice-56");
    	System.loadLibrary("sfftranscoder");
    }
    
}
