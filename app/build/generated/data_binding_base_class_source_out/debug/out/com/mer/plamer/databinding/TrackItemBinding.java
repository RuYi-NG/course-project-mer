// Generated by view binder compiler. Do not edit!
package com.mer.plamer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mer.plamer.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TrackItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView trackItemArtist;

  @NonNull
  public final ImageView trackItemBackground;

  @NonNull
  public final TextView trackItemLength;

  @NonNull
  public final TextView trackItemName;

  private TrackItemBinding(@NonNull ConstraintLayout rootView, @NonNull TextView trackItemArtist,
      @NonNull ImageView trackItemBackground, @NonNull TextView trackItemLength,
      @NonNull TextView trackItemName) {
    this.rootView = rootView;
    this.trackItemArtist = trackItemArtist;
    this.trackItemBackground = trackItemBackground;
    this.trackItemLength = trackItemLength;
    this.trackItemName = trackItemName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TrackItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TrackItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.track_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TrackItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.track_item_artist;
      TextView trackItemArtist = ViewBindings.findChildViewById(rootView, id);
      if (trackItemArtist == null) {
        break missingId;
      }

      id = R.id.track_item_background;
      ImageView trackItemBackground = ViewBindings.findChildViewById(rootView, id);
      if (trackItemBackground == null) {
        break missingId;
      }

      id = R.id.track_item_length;
      TextView trackItemLength = ViewBindings.findChildViewById(rootView, id);
      if (trackItemLength == null) {
        break missingId;
      }

      id = R.id.track_item_name;
      TextView trackItemName = ViewBindings.findChildViewById(rootView, id);
      if (trackItemName == null) {
        break missingId;
      }

      return new TrackItemBinding((ConstraintLayout) rootView, trackItemArtist, trackItemBackground,
          trackItemLength, trackItemName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
