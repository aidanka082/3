package home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.aydaninnotesapp.databinding.FragmentHomeBinding;

import adapter.HomeAdapter;
import ui.TaskModel;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private TaskModel model;
    private HomeAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        intRecycler();
        getData();
        return binding.getRoot();
    }

    private void intRecycler() {
        adapter = new HomeAdapter();
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.addModel(new TaskModel("Life Cycles","OnCreate"));
        adapter.addModel(new TaskModel("Life Cycles","OnStart"));
        adapter.addModel(new TaskModel("Life Cycles","OnResumе"));
        adapter.addModel(new TaskModel("Life Cycles","OnPause"));
        adapter.addModel(new TaskModel("Life Cycles","OnStop"));
        adapter.addModel(new TaskModel("Life Cycles","OnDestroy"));
    }
    private void getData() {
        getParentFragmentManager().setFragmentResultListener("title", getViewLifecycleOwner(), ((requestKey, result) -> {
             TaskModel model = (TaskModel) result.getSerializable("not");
             adapter.addModel(model);
        }));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

}