package com.example.community;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookDisplayAdapter extends RecyclerView.Adapter<BookDisplayAdapter.ViewHolder> {
    private List<BooksDisplay>booksDisplayList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bookPicPath;

        TextView bookName;

        TextView bookIntroduction;


        public ViewHolder (View view){
            super(view);
            bookPicPath=view.findViewById(R.id.bookPicPath);

            bookName=view.findViewById(R.id.bookName);

            bookIntroduction=view.findViewById(R.id.bookIntroduction);

        }
    }
    public BookDisplayAdapter(List<BooksDisplay>bookDisplayList1){
        booksDisplayList=bookDisplayList1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.books_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BooksDisplay booksDisplay=booksDisplayList.get(position);
        holder.bookPicPath.setImageResource(booksDisplay.getBookPicPath());

        holder.bookName.setText(booksDisplay.getBookName());

        holder.bookIntroduction.setText(booksDisplay.getBookIntroduction());

    }

    @Override
    public long getItemId(int position) {
        return booksDisplayList.size();
    }

    @Override
    public int getItemCount() {
        return booksDisplayList.size();
    }
}
