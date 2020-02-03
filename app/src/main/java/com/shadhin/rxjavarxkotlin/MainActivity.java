package com.shadhin.rxjavarxkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {
    private String greeting = "Hello ShadhiN";
    private Observable<String> myObservable;
    private Observer<String> myObserver;
    private final static String TAG = "myApp";
    private TextView txtMyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMyText = findViewById(R.id.txtMyText);
        myObservable = Observable.just(greeting);
        myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "OnSubscribe Invoke");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "OnNext Invoke");
                txtMyText.setText(greeting);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "OnError Invoke");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "OnComplete Invoke");
            }
        };myObservable.subscribe(myObserver);
    }
}
