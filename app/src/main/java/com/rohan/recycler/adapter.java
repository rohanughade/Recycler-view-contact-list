package com.rohan.recycler;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class adapter extends RecyclerView.Adapter<adapter.viewHolder> {
    Context context;
    ArrayList<contactModel>arrCon;
    adapter(Context context,ArrayList<contactModel> arrCon){
        this.arrCon=arrCon;
        this.context=context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        viewHolder viewHolder= new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.img.setImageResource(arrCon.get(position).img);
        holder.nmae.setText(arrCon.get(position).name);
        holder.number.setText(arrCon.get(position).number);
        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dailog_box);
                EditText nmae,number;
                nmae = dialog.findViewById(R.id.name);
                number = dialog.findViewById(R.id.number);
                Button btn = dialog.findViewById(R.id.btn);
                TextView txt = dialog.findViewById(R.id.txt);
                txt.setText("Update Contact");
                btn.setText("Update");
                nmae.setText(arrCon.get(position).name);
                number.setText(arrCon.get(position).number);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",num="";
                        if (!nmae.getText().toString().isEmpty()){
                            name = nmae.getText().toString();

                        }else {
                            Toast.makeText(context, "Please Enter Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!number.getText().toString().isEmpty()){
                            num = number.getText().toString();

                        }else {
                            Toast.makeText(context, "Please Enter Number", Toast.LENGTH_SHORT).show();
                        }

                        arrCon.set(position,new contactModel(arrCon.get(position).img,name,num));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();


            }
        });

        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle("Delete contact");
                builder.setMessage("Do you want to delete contact");
                builder.setIcon(R.drawable.baseline_delete_24);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrCon.remove(position);
                        notifyItemRemoved(position);
                        notifyItemChanged(position,arrCon.size());

                    }
                });
                        builder.setNegativeButton("no",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();


                            }
                        });
                     builder.show();

                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrCon.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView nmae, number;
        LinearLayout llrow;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            nmae = itemView.findViewById(R.id.contactText);
            number = itemView.findViewById(R.id.contactNum);
            llrow = itemView.findViewById(R.id.llrow);
        }
    }
}
