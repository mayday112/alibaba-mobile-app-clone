package com.example.utsecommerce.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsecommerce.Adapters.ItemAdapter;
import com.example.utsecommerce.Models.ItemModel;
import com.example.utsecommerce.R;
import com.example.utsecommerce.Utilities.RupiahFormatter;
import com.example.utsecommerce.databinding.FragmentBerandaBinding;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BerandaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BerandaFragment extends Fragment {
    FragmentBerandaBinding fragmentBerandaBinding;
    RecyclerView.Adapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BerandaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BerandaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BerandaFragment newInstance(String param1, String param2) {
        BerandaFragment fragment = new BerandaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    private void initTopItem() {
        ArrayList<ItemModel> items = new ArrayList<>();

        ItemModel item1 = new ItemModel();
        item1.setNama("Kamera");
        item1.setHarga("45780000");
        item1.setDeskripsi("Lorem ipsum dolor sit amet");
        item1.setPhotoPath(String.valueOf(R.drawable.kamera_canon));
        item1.setMinPesan("1");
        ArrayList<String> varians = new ArrayList<>();
        String[] varian = {"R1", "R2", "R56"};
        varians.addAll(Arrays.asList(varian));
        item1.setVarian(varians);
        items.add(item1);

        ItemModel item2 = new ItemModel();
        item2.setNama("Lensa");
        item2.setHarga("1580000");
        item2.setDeskripsi("Lorem ipsum dolor sit amet");
        item2.setPhotoPath(String.valueOf(R.drawable.lensa_canon));
        item2.setMinPesan("3");
        varians = new ArrayList<>();
        varian = new String[]{"1.5 mm", "3.5 mm", "5.5 mm"};
        varians.addAll(Arrays.asList(varian));
        item2.setVarian(varians);
        items.add(item2);

        ItemModel item3 = new ItemModel();
        item3.setNama("Celana Jeans");
        item3.setHarga("250000");
        item3.setDeskripsi("Lorem ipsum dolor sit amet");
        item3.setPhotoPath(String.valueOf(R.drawable.celana_jeans));
        item3.setMinPesan("1");
        varians = new ArrayList<>();
        varian = new String[]{"S", "L", "XL"};
        varians.addAll(Arrays.asList(varian));
        item3.setVarian(varians);
        items.add(item3);


        adapter = new ItemAdapter(items);
        fragmentBerandaBinding.topItemsRecycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        fragmentBerandaBinding.topItemsRecycleView.setAdapter(adapter);

        fragmentBerandaBinding.newArrivalsRecycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        fragmentBerandaBinding.newArrivalsRecycleView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentBerandaBinding = FragmentBerandaBinding.inflate(inflater, container, false);
        initTopItem();
        return fragmentBerandaBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Hapus binding untuk mencegah memory leak
        fragmentBerandaBinding = null;
    }


}