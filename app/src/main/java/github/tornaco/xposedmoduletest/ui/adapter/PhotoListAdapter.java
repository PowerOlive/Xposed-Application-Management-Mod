package github.tornaco.xposedmoduletest.ui.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import dev.tornaco.vangogh.Vangogh;
import dev.tornaco.vangogh.display.CircleImageEffect;
import dev.tornaco.vangogh.display.appliers.ResAnimationApplier;
import dev.tornaco.vangogh.display.appliers.ScaleInXYApplier;
import github.tornaco.xposedmoduletest.R;
import github.tornaco.xposedmoduletest.bean.AccessInfo;
import si.virag.fuzzydateformatter.FuzzyDateTimeFormatter;

/**
 * Created by guohao4 on 2017/10/18.
 * Email: Tornaco@163.com
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.AccessiewHolder> {

    private Context context;

    public PhotoListAdapter(Context context) {
        this.context = context;
    }

    private final List<AccessInfo> accessInfos = new ArrayList<>();

    public void update(Collection<AccessInfo> src) {
        synchronized (accessInfos) {
            accessInfos.clear();
            accessInfos.addAll(src);
        }
        notifyDataSetChanged();
    }

    @Override
    public AccessiewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getTemplateLayoutRes(), parent, false);
        return new AccessiewHolder(view);
    }

    @LayoutRes
    private int getTemplateLayoutRes() {
        return R.layout.photo_list_item;
    }

    @Override
    public void onBindViewHolder(final AccessiewHolder holder, int position) {
        final AccessInfo accessInfo = accessInfos.get(position);
        holder.textView.setText(FuzzyDateTimeFormatter.getTimeAgo(context, new Date(accessInfo.getWhen())));
        Vangogh.with(context)
                .load(accessInfo.getUrl())
                .skipMemoryCache(true)
                .applier(new ResAnimationApplier(context, R.anim.grow_fade_in))
                .placeHolder(0)
                .effect(new CircleImageEffect())
                .fallback(R.mipmap.ic_launcher_round)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return accessInfos.size();
    }

    static class AccessiewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        AccessiewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.photo);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}
