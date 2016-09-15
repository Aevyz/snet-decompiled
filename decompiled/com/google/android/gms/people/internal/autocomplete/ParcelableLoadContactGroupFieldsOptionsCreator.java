package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.wireless.android.play.playlog.proto.UserLocation.TimeSelection.Type;

public class ParcelableLoadContactGroupFieldsOptionsCreator implements Creator<ParcelableLoadContactGroupFieldsOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    public ParcelableLoadContactGroupFieldsOptions createFromParcel(Parcel parcel) {
        int end = SafeParcelReader.validateObjectHeader(parcel);
        int _local_safe_0a1b_mVersionCode = 0;
        String _local_safe_0a1b_mContactGroupId = null;
        while (parcel.dataPosition() < end) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case Type.TEMPORARY /*1*/:
                    _local_safe_0a1b_mVersionCode = SafeParcelReader.readInt(parcel, header);
                    break;
                case Type.INDEFINITELY /*2*/:
                    _local_safe_0a1b_mContactGroupId = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        if (parcel.dataPosition() == end) {
            return new ParcelableLoadContactGroupFieldsOptions(_local_safe_0a1b_mVersionCode, _local_safe_0a1b_mContactGroupId);
        }
        throw new ParseException("Overread allowed size end=" + end, parcel);
    }

    public ParcelableLoadContactGroupFieldsOptions[] newArray(int size) {
        return new ParcelableLoadContactGroupFieldsOptions[size];
    }

    static void writeToParcel(ParcelableLoadContactGroupFieldsOptions obj, Parcel parcel, int flags) {
        int myStart = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, obj.mVersionCode);
        SafeParcelWriter.writeString(parcel, 2, obj.mContactGroupId, false);
        SafeParcelWriter.finishObjectHeader(parcel, myStart);
    }
}
