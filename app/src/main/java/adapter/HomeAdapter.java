package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aydaninnotesapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import ui.TaskModel;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    ArrayList<TaskModel>list = new ArrayList<>();
    public  void  addModel(TaskModel model){
        list.add(model);
        notifyDataSetChanged();
    }
    @NonNull
    @NotNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeAdapter.ViewHolder holder, int position) {
        holder.OnBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item);
            desc = itemView.findViewById(R.id.desc_item);
        }
        public void OnBind(TaskModel taskModel) {
            title.setText(taskModel.getTitle());
            desc.setText(taskModel.getDesc());
        }
    }
}
