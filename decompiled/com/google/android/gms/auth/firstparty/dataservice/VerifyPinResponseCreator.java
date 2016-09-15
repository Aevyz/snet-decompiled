package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.wireless.android.play.playlog.proto.UserLocation.TimeSelection.Type;

public class VerifyPinResponseCreator implements Creator<VerifyPinResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    public VerifyPinResponse createFromParcel(Parcel parcel) {
        int end = SafeParcelReader.validateObjectHeader(parcel);
        int _local_safe_0a1b_version = 0;
        int _local_safe_0a1b_status = 0;
        String _local_safe_0a1b_rapt = null;
        while (parcel.dataPosition() < end) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case Type.TEMPORARY /*1*/:
                    _local_safe_0a1b_version = SafeParcelReader.readInt(parcel, header);
                    break;
                case Type.INDEFINITELY /*2*/:
                    _local_safe_0a1b_status = SafeParcelReader.readInt(parcel, header);
                    break;
                case Type.CUSTOM /*3*/:
                    _local_safe_0a1b_rapt = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        if (parcel.dataPosition() == end) {
            return new VerifyPinResponse(_local_safe_0a1b_version, _local_safe_0a1b_status, _local_safe_0a1b_rapt);
        }
        throw new ParseException("Overread allowed size end=" + end, parcel);
    }

    public VerifyPinResponse[] newArray(int size) {
        return new VerifyPinResponse[size];
    }

    static void writeToParcel(VerifyPinResponse obj, Parcel parcel, int flags) {
        int myStart = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, obj.version);
        SafeParcelWriter.writeInt(parcel, 2, obj.status);
        SafeParcelWriter.writeString(parcel, 3, obj.rapt, false);
        SafeParcelWriter.finishObjectHeader(parcel, myStart);
    }
}
