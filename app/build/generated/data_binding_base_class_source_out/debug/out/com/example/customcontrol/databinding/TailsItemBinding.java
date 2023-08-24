// Generated by view binder compiler. Do not edit!
package com.example.customcontrol.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.customcontrol.R;
import com.example.customcontrol.SwipeToDeleteView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TailsItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final SwipeToDeleteView swipeToDeleteView;

  @NonNull
  public final ImageView tailsImage;

  @NonNull
  public final TextView tailsName;

  private TailsItemBinding(@NonNull LinearLayout rootView,
      @NonNull SwipeToDeleteView swipeToDeleteView, @NonNull ImageView tailsImage,
      @NonNull TextView tailsName) {
    this.rootView = rootView;
    this.swipeToDeleteView = swipeToDeleteView;
    this.tailsImage = tailsImage;
    this.tailsName = tailsName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TailsItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TailsItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.tails_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TailsItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.swipeToDeleteView;
      SwipeToDeleteView swipeToDeleteView = ViewBindings.findChildViewById(rootView, id);
      if (swipeToDeleteView == null) {
        break missingId;
      }

      id = R.id.tailsImage;
      ImageView tailsImage = ViewBindings.findChildViewById(rootView, id);
      if (tailsImage == null) {
        break missingId;
      }

      id = R.id.tailsName;
      TextView tailsName = ViewBindings.findChildViewById(rootView, id);
      if (tailsName == null) {
        break missingId;
      }

      return new TailsItemBinding((LinearLayout) rootView, swipeToDeleteView, tailsImage,
          tailsName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}