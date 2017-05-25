package sheva.serverwork2.mvp.view.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sheva.serverwork2.R;
import sheva.serverwork2.mvp.model.entities.TokenEntity;
import sheva.serverwork2.mvp.model.entities.UserEntity;
import sheva.serverwork2.mvp.presenter.activities.MainActivityPresenter;
import sheva.serverwork2.mvp.view.adapter.UsersAdapter;
import sheva.serverwork2.mvp.view.interfaces.IMainActivityView;

public class MainActivity extends MvpAppCompatActivity implements IMainActivityView{
    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;
    @InjectPresenter
    MainActivityPresenter presenter;
    private UsersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new UsersAdapter(this);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        rvUsers.setAdapter(adapter);
        fetchUsersFromServer(getIntent().getParcelableExtra("TOKEN"));
    }

    @Override
    public void onUpdateList(List<UserEntity> list) {
        adapter.updateList(list);
    }

    @Override
    public void fetchUsersFromServer(TokenEntity tokenEntity) {
        presenter.getUsersFromServer(tokenEntity);
    }

    @Override
    public void onFetched() {
        presenter.updateList();
    }
}
