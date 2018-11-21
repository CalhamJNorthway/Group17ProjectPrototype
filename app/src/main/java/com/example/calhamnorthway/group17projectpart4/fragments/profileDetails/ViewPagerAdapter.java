package com.example.calhamnorthway.group17projectpart4.fragments.profileDetails;

import android.content.Context;
import android.view.LayoutInflater;
import com.example.calhamnorthway.group17projectpart4.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ViewPagerAdapter extends android.support.v4.view.PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    int[] imageIdArray;

    public ViewPagerAdapter(Context context, int[] imageIdArray) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageIdArray = imageIdArray;
    }

    @Override
    public int getCount() {
        return imageIdArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item_image, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.profileImage);
        imageView.setImageResource(imageIdArray[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}