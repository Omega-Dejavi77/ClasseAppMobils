package cat.tecnocampus.mobileapps.listsensors;

import android.hardware.Sensor;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView vendor;
        public TextView type;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            vendor = itemView.findViewById(R.id.vendor);
            type = itemView.findViewById(R.id.type);
        }
    }

    private List<Sensor> sensorItems;

    public MyAdapter(List<Sensor> sensorItems) {
        this.sensorItems = sensorItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sensor_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sensor currentData = this.sensorItems.get(position);
        holder.name.setText(currentData.getName());
        holder.vendor.setText(currentData.getVendor());
        holder.type.setText(currentData.getStringType());
    }

    @Override
    public int getItemCount() {
        return this.sensorItems.size();
    }
}
