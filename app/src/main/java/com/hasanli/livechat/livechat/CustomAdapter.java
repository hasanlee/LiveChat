package com.hasanli.livechat.livechat;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class CustomAdapter extends ArrayAdapter<Chat> implements View.OnClickListener{

    private ArrayList<Chat> dataSet;
    Context mContext;

    protected abstract void populateViewHolder(ChatActivity.MessageViewHolder viewHolder,
                                               Chat chat, int position);


    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtMsg;
        ImageView imgUrl;
    }

    public CustomAdapter(ArrayList<Chat> data, Context context) {
        super(context, R.layout.message_row, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Chat dataModel=(Chat)object;

        Snackbar.make(v, "Release date " +dataModel.getId(), Snackbar.LENGTH_LONG).setAction("No action", null).show();
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Chat dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.message_row, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.messengerTextView);
            viewHolder.txtMsg = (TextView) convertView.findViewById(R.id.messageTextView);
            viewHolder.imgUrl = (ImageView) convertView.findViewById(R.id.messageImageView);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtMsg.setText(dataModel.getMsg());
        viewHolder.imgUrl.setOnClickListener(this);
        viewHolder.imgUrl.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}