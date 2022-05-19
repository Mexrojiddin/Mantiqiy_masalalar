package uz.mexboy.mantiqiymasalalar.ui.mundarija;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
;
import uz.mexboy.mantiqiymasalalar.MainActivity;
import uz.mexboy.mantiqiymasalalar.R;
import uz.mexboy.mantiqiymasalalar.adapter.MundarijaAdapter;
import uz.mexboy.mantiqiymasalalar.model.MundarijaModel;
import uz.mexboy.mantiqiymasalalar.ui.home.HomeFragment;

public class MundarijaFragment extends Fragment implements MundarijaAdapter.ItemClickListener {
    private Context mContext;
    private View root;
    private List<MundarijaModel> data;

    private RecyclerView recyclerView;

    private MundarijaAdapter mundarijaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mundarija, container, false);

        init();
        return root;
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new MundarijaModel("BOSH SAHIFA", 0));
        data.add(new MundarijaModel("So'z boshi", 2));
        data.add(new MundarijaModel("To`plam elementlarini tartiblashga doir mantiqiy masalalarni yechish usullari", 3));
        data.add(new MundarijaModel("To`plam elementlari o`rtasida o`zaro bir qiymatli moslikni o`rnatishga doir mantiqiy masalalarni yechish usullari", 8));
        data.add(new MundarijaModel("Kechib o`tishga doir mantiqiy masalalarni yechish usullari", 17));
        data.add(new MundarijaModel("Quyib olishga doir mantiqiy masalalarni yechish usullari", 23));
        data.add(new MundarijaModel("Eng yomon holni ko`rish va Dirihle prinsipiga doi mantiqiy masalalarni yechish usullari", 29));
        data.add(new MundarijaModel("Tarozida tortishga doir mantiqiy masalalarni yechish usullari", 32));
        data.add(new MundarijaModel("Gipotezalar tuzish va tekshirish asosida mantiqiy masalalarni yechish usullari", 36));
        data.add(new MundarijaModel("Masalalar", 42));
        data.add(new MundarijaModel("Qonuniyatlarni topishga doir mashqlar", 49));
        data.add(new MundarijaModel("Sonli rebuslarga doir mashqlarni yechish usullari", 57));
        data.add(new MundarijaModel("Kombinatorik masala haqida tushuncha. Kombinatorik masalalarning asosiy turlari", 68));
        data.add(new MundarijaModel("Boshlang`ich sinflar matematikasida kombinatorik masalalar va ularni yechish usullari", 81));
        data.add(new MundarijaModel("Nostandart arifmetik masalalarni yordamchi model qo`llash usuli bilan yechish", 83));
        data.add(new MundarijaModel("Nostandart arifmetik masalalarni yordamchi element kiritish usuli bilan yechish", 83));
        data.add(new MundarijaModel("Nostandart arifmetik masalalarni tanlash usuli bilan yechish", 85));
        data.add(new MundarijaModel("Nostandart arifmetik masalalarni “oxiridan boshlab” usuli bilan yechish", 85));
        data.add(new MundarijaModel("Nostandart arifmetik masalalarni turli evristik usullar bilan yechish", 87));
        data.add(new MundarijaModel("Masalalar", 89));
        data.add(new MundarijaModel("JAVOBLAR", 96));
        data.add(new MundarijaModel("FOYDALANILGAN ADABIYOTLAR", 98));

        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mundarijaAdapter = new MundarijaAdapter(mContext, data);
        mundarijaAdapter.setClickListener(this);
        recyclerView.setAdapter(mundarijaAdapter);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onItemClick(View view, int position) {
        MainActivity.defaultPage = data.get(position).getPage();

        MainActivity.toolbar.setTitle("Bosh sahifa");
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_host_fragment,
                        new HomeFragment())

                .commit();

        getActivity().getSupportFragmentManager().popBackStackImmediate();

        MainActivity.navPage = R.id.nav_home;


    }
}