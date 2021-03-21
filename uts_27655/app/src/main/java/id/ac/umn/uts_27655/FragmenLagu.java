package id.ac.umn.uts_27655;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static id.ac.umn.uts_27655.HalamanListLagu.fileLagu;

public class FragmenLagu extends Fragment {
    RecyclerView recyclerView;
    AdapterLagu adapterLagu;

    public FragmenLagu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_lagu, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        if(!(fileLagu.size() < 1)) {
            adapterLagu = new AdapterLagu(getContext(), fileLagu);
            recyclerView.setAdapter(adapterLagu);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,
                    false));
        }
        return view;
    }
}
