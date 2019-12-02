package ch.lammel.photobooth.webservice.test;
/*

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import org.gphoto2.CameraFile;
import org.gphoto2.CameraList;
import org.gphoto2.CameraUtils;
import org.gphoto2.CameraWidgets;
import org.gphoto2.jna.GPhoto2Native;
import org.gphoto2.jna.GPhoto2Native.CameraFilePath;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class Camera implements Closeable {

    final Pointer camera;

    public Camera() {
        final PointerByReference ref = new PointerByReference();
        CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_new(ref), "gp_camera_new");
        camera = ref.getValue();
    }
    private boolean isInitialized = false;

    public void initialize() {
        checkNotClosed();
        if (!isInitialized) {
            CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_init(camera, CameraList.CONTEXT), "gp_camera_init");
            isInitialized = true;
        }
    }

    public boolean isClosed() {
        return closed;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void deinitialize() throws IOException {
        checkNotClosed();
        if (isInitialized) {
            isInitialized = false;
            CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_exit(camera, CameraList.CONTEXT), "gp_camera_exit");
        }
    }

    private boolean closed = false;

    public void close() throws IOException {
        if (!closed) {
            deinitialize();
            closed = true;
            CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_free(camera), "gp_camera_free");
        }
    }

    private void checkNotClosed() {
        if (closed) {
            throw new IllegalStateException("Invalid state: closed");
        }
    }

    public CameraFile capturePreview() {
        checkNotClosed();
        boolean returnedOk = false;
        final CameraFile cfile = new CameraFile();
        try {
            CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_capture_preview(camera, cfile.cf, CameraList.CONTEXT), "gp_camera_capture_preview");
            returnedOk = true;
            return cfile;
        } finally {
            if (!returnedOk) {
                CameraUtils.closeQuietly(cfile);
            }
        }
    }

    public CameraWidgets newConfiguration() {
        checkNotClosed();
        return new CameraWidgets(this);
    }

    public CameraFile captureImage() {
        checkNotClosed();
        final CameraFilePath path = new CameraFilePath.ByReference();
        CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_capture(camera, GPhoto2Native.GP_CAPTURE_IMAGE, path, CameraList.CONTEXT), "gp_camera_capture");
        final Path p = new CameraFile.Path(path);
        return p.newFile(camera);
    }

    void ref() {
        checkNotClosed();
        CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_ref(camera), "gp_camera_ref");
    }

    void unref() {
        checkNotClosed();
        CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_unref(camera), "gp_camera_ref");
    }

    public static String getLibraryVersion() {
        final String[] versions = GPhoto2Native.INSTANCE.gp_library_version(GPhoto2Native.GP_VERSION_VERBOSE);
        final StringBuilder sb = new StringBuilder();
        for (final String v : versions) {
            sb.append(v).append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        final boolean autoFocus = false;
        final boolean preview = false;
        System.out.println("GPhoto version: " + getLibraryVersion());
        final CameraList cl = new CameraList();
        try {
            System.out.println("Cameras: " + cl);
        } finally {
            CameraUtils.closeQuietly(cl);
        }
        final Camera c = new Camera();
        try {
            c.initialize();
            if (autoFocus) {
                final CameraWidgets cfg = c.newConfiguration();
                try {
                    cfg.setValue("/actions/autofocusdrive", true);
                    cfg.apply();
                } finally {
                    CameraUtils.closeQuietly(cfg);
                }
            }
            if (preview) {
                final CameraFile cf = c.capturePreview();
                try {
                    cf.save(new File("preview.jpg").getAbsolutePath());
                } finally {
                    CameraUtils.closeQuietly(cf);
                }
                c.deinitialize();
                c.initialize();
            }
            // The Canon EOS 1000D for some reason ignores the autofocusdrive setting: it performs auto-focus only when there was no previous preview... weird.
            final CameraFile cf2 = c.captureImage();
            try {
                cf2.save(new File("captured.jpg").getAbsolutePath());
            } finally {
                CameraUtils.closeQuietly(cf2);
            }
        } finally {
            CameraUtils.closeQuietly(c);
        }
    }
    
    public void setPortInfo(Pointer portInfo) {
        checkNotClosed();
        CameraUtils.check(GPhoto2Native.INSTANCE.gp_camera_set_port_info(camera, portInfo), "gp_camera_set_port_info");
    }
}*/