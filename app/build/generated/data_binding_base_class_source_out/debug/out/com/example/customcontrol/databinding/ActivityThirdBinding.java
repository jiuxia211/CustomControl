// Generated by view binder compiler. Do not edit!
package com.example.customcontrol.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.customcontrol.R;
import com.example.customcontrol.StatisticChartView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityThirdBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final StatisticChartView barChart;

  @NonNull
  public final Button lastButton;

  @NonNull
  public final TextView text;

  private ActivityThirdBinding(@NonNull ConstraintLayout rootView,
      @NonNull StatisticChartView barChart, @NonNull Button lastButton, @NonNull TextView text) {
    this.rootView = rootView;
    this.barChart = barChart;
    this.lastButton = lastButton;
    this.text = text;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityThirdBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityThirdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_third, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityThirdBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bar_chart;
      StatisticChartView barChart = ViewBindings.findChildViewById(rootView, id);
      if (barChart == null) {
        break missingId;
      }

      id = R.id.last_button;
      Button lastButton = ViewBindings.findChildViewById(rootView, id);
      if (lastButton == null) {
        break missingId;
      }

      id = R.id.text;
      TextView text = ViewBindings.findChildViewById(rootView, id);
      if (text == null) {
        break missingId;
      }

      return new ActivityThirdBinding((ConstraintLayout) rootView, barChart, lastButton, text);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
