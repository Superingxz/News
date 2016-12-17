package com.jeason.news.simple;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/17.
 */

public class BannerPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] imageUrls = new String[]{};
    private OkGo okGo;
    public BannerPagerAdapter(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
        this.okGo = OkGo.getInstance();
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ImageView imageView = new ImageView(context);
        if (imageUrls[position] != null) {
            OkGo.get(imageUrls[position])//
                    .tag(this)//

                    .execute(new BitmapCallback() {
                        @Override
                        public void onSuccess(Bitmap bitmap, Call call, Response response) {
                            imageView.setImageBitmap(bitmap);

                        }
                    });
        }

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView imageView = (ImageView) object;
        container.removeView(imageView);
    }
}
