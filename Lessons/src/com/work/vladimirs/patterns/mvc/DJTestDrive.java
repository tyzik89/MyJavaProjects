package com.work.vladimirs.patterns.mvc;

import com.work.vladimirs.patterns.mvc.controller.BeatController;
import com.work.vladimirs.patterns.mvc.controller.ControllerInterface;
import com.work.vladimirs.patterns.mvc.model.BeatModel;
import com.work.vladimirs.patterns.mvc.model.BeatModelInterface;

public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
