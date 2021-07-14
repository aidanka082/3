package ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aydaninnotesapp.R;
import com.example.aydaninnotesapp.databinding.FragmentNoteBinding;

import org.jetbrains.annotations.NotNull;


public class NoteFragment extends Fragment {
    private FragmentNoteBinding binding;
    private TaskModel model;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
      @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btn.setOnClickListener(v -> save());
    }
        private void save() {
            binding.btn.setOnClickListener(v -> {
            String title2 = binding.etText1.getText().toString();
            String desc2= binding.etLog.getText().toString();
            model = new TaskModel(title2,desc2);
            Bundle bundle = new Bundle();
            bundle.putSerializable("not",model);
            Log.d("Tag","save:" + model.getTitle() + model.getDesc());
            getParentFragmentManager().setFragmentResult("title",bundle);
                navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                navController.navigateUp();
            });
        }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

