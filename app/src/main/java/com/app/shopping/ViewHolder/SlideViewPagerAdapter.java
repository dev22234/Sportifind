package com.app.shopping.ViewHolder;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.app.shopping.MainActivity;
import com.app.shopping.R;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_screen,container,false);


        ImageView logo=view.findViewById(R.id.imageView);

        ImageView ind1=view.findViewById(R.id.ind1);
        ImageView ind2=view.findViewById(R.id.ind2);
        ImageView ind3=view.findViewById(R.id.ind3);
        TextView title=view.findViewById(R.id.textView);
        TextView desc=view.findViewById(R.id.textView2);

        ImageView next=view.findViewById(R.id.next);
        ImageView back=view.findViewById(R.id.back);

        Button btnGetStarted=view.findViewById(R.id.get_started_btn);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                com.app.shopping.ViewHolder.SlideActivity.viewPager.setCurrentItem(position+1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.app.shopping.ViewHolder.SlideActivity.viewPager.setCurrentItem(position-1);
            }
        });

        switch (position)
        {
            case 0:
                logo.setImageResource(R.drawable.logo);
                ind1.setImageResource(R.drawable.seleted);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);

                title.setText("Sportifind");
                desc.setText("The Ultimate Turf Booking Destination");
                back.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                break;
            case 1:
                logo.setImageResource(R.drawable.head_login);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.seleted);
                ind3.setImageResource(R.drawable.unselected);

                title.setText("Booking on the go");
                desc.setText("Book your turf from Anywhere, anytime");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                break;
            case 2:
                logo.setImageResource(R.drawable.phone3);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.seleted);

                title.setText("Cancel at anytime");
                desc.setText("Ease of Cancellations");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.GONE);
                break;

        }


        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}