package com.fleetbase.navigator;

import android.app.Application;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.horcrux.svg.SvgPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import android.content.Context; // make sure you are not importing multiple times
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Arrays;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
      @Override
      public boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
      }

      @Override
      protected List<ReactPackage> getPackages() {
        @SuppressWarnings("UnnecessaryLocalVariable")
        List<ReactPackage> packages = new PackageList(this).getPackages();

        return packages;
      }

      @Override
      protected String getJSMainModuleName() {
        return "index";
      }
};

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
   public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {
    if (Build.VERSION.SDK_INT >= 34 && getApplicationInfo().targetSdkVersion >= 34) {
      return super.registerReceiver(receiver, filter, Context.RECEIVER_EXPORTED);
    } else {
      return super.registerReceiver(receiver, filter);
    }
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
