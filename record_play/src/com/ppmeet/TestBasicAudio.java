package com.ppmeet;

import java.io.IOException;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
* class name：TestBasicAudio<BR>
* class description：Basic Record Audio Demo<BR>
*
* @version 1.00 2011/12/01
* @author CODYY)peijiangping
*/
public class TestBasicAudio extends Activity {
        private Button button_start;
        private Button button_stop;
        private MediaRecorder recorder;

        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                getWindow().setFormat(PixelFormat.TRANSLUCENT);// 让界面横屏
                requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉界面标题
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                // 重新设置界面大小
                setContentView(R.layout.activity_test_basic_audio);
                init();
        }

        private void init() {
                button_start = (Button) this.findViewById(R.id.start);
                button_stop = (Button) this.findViewById(R.id.stop);
                button_stop.setOnClickListener(new AudioListerner());
                button_start.setOnClickListener(new AudioListerner());
        }

        class AudioListerner implements OnClickListener {
                @Override
                public void onClick(View v) {
                        if (v == button_start) {
                                initializeAudio();
                        }
                        if (v == button_stop) {
                                recorder.stop();// 停止刻录
                                // recorder.reset(); // 重新启动MediaRecorder.
                                recorder.release(); // 刻录完成一定要释放资源
                                // recorder = null;
                        }
                }

                private void initializeAudio() {
                        recorder = new MediaRecorder();// new出MediaRecorder对象
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        // 设置MediaRecorder的音频源为麦克风
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);
                        // 设置MediaRecorder录制的音频格式
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        // 设置MediaRecorder录制音频的编码为amr.
                        recorder.setOutputFile("/sdcard/test.amr");
                        // 设置录制好的音频文件保存路径
                        try {
                                recorder.prepare();// 准备录制
                                recorder.start();// 开始录制
                        } catch (IllegalStateException e) {
                                e.printStackTrace();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                }
        }
}
