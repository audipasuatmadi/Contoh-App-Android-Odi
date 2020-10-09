package com.example.roomlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserDataListAdapter extends RecyclerView.Adapter<UserDataListAdapter.UserDataViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<UserData> mUserDatas;

    public UserDataListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    class UserDataViewHolder extends RecyclerView.ViewHolder {
        private final TextView usernameView;
        private final TextView pinView;

        public UserDataViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameView = itemView.findViewById(R.id.userdata_username);
            pinView = itemView.findViewById(R.id.userdata_pin);
        }
    }

    @NonNull
    @Override
    public UserDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new UserDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserDataViewHolder holder, int position) {
        if (mUserDatas == null) {
            holder.usernameView.setText("Zonk");
            holder.pinView.setText("Zonk");
        } else {
            UserData currentPos = mUserDatas.get(position);
            String pin = String.valueOf(currentPos.getPin());
            holder.pinView.setText(pin);
            holder.usernameView.setText(currentPos.getUserName());

        }
    }

    void setUserDatas(List<UserData> userDatas) {
        mUserDatas = userDatas;
        notifyDataSetChanged();
    }

    public UserData getUserDataAtPos(int pos) {
        return mUserDatas.get(pos);
    }

    @Override
    public int getItemCount() {
        if (mUserDatas != null) {
            return mUserDatas.size();
        }
        return 0;
    }
}
