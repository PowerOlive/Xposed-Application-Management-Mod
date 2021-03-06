package github.tornaco.xposedmoduletest.ui.tiles.green;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.RelativeLayout;

import dev.nick.tiles.tile.QuickTile;
import dev.nick.tiles.tile.SwitchTileView;
import github.tornaco.xposedmoduletest.R;
import github.tornaco.xposedmoduletest.xposed.app.XAPMManager;

/**
 * Created by Tornaco on 2018/4/28 13:36.
 * God bless no bug!
 */
public class LazySolutionFw extends QuickTile {

    public LazySolutionFw(@NonNull Context context) {
        super(context, null);

        this.titleRes = R.string.title_lazy_solution_fw;
        this.summaryRes = R.string.summary_lazy_solution_fw;
        this.iconRes = R.drawable.ic_looks_two_black_24dp;

        this.tileView = new SwitchTileView(context) {
            @Override
            protected void onBindActionView(RelativeLayout container) {
                super.onBindActionView(container);
                setChecked(XAPMManager.get().isAppServiceLazyControlSolutionEnable(XAPMManager.AppServiceControlSolutions.FLAG_FW));
            }

            @Override
            protected void onCheckChanged(boolean checked) {
                super.onCheckChanged(checked);
                XAPMManager.get().setAppServiceLazyControlSolution(XAPMManager.AppServiceControlSolutions.FLAG_FW, checked);
            }
        };

    }
}
