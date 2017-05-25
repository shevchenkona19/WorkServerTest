package sheva.serverwork2.mvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sheva.serverwork2.R;
import sheva.serverwork2.mvp.model.entities.UserEntity;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>{
    private List<UserEntity> list;
    private LayoutInflater inflater;

    public UsersAdapter(Context context) {
        list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_each_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.tvUsername.setText(list.get(position).getUsername());
        holder.tvLastLogin.setText(list.get(position).getLastLogin());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateList(List<UserEntity> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvItemLastLogin)
        TextView tvLastLogin;
        @BindView(R.id.tvItemUsername)
        TextView tvUsername;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
