/*
 * Copyright (C) 2010 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shudongedu.energy.codebar.decoding;

import android.app.Activity;
import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/**
 * Simple listener used to exit the app in a few cases.
 */
public final class FinishListener
    implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

  private final WeakReference<Activity> mWeakActivity;

  /**
   * 构造器
   *
   * @param activityToFinish 要被finish的Activity
   */
  public FinishListener(Activity activityToFinish) {
    mWeakActivity = new WeakReference<Activity>(activityToFinish);
  }

  /**
   * 取消动作出发Activity的finish<BR>
   *
   * @param dialogInterface 触发取消操作的DialogInterface实例
   */
  public void onCancel(DialogInterface dialogInterface) {
    run();
  }

  /**
   * 点击动作出发Activity的finish<BR>
   *
   * @param dialogInterface 触发点击操作的DialogInterface实例
   * @param i Button的ID
   */
  public void onClick(DialogInterface dialogInterface, int i) {
    run();
  }

  /**
   * 由线程池执行的finish<BR>
   */
  public void run() {
    Activity activityToFinish = mWeakActivity.get();
    if (null != activityToFinish) {
      activityToFinish.finish();
    }
  }
}
