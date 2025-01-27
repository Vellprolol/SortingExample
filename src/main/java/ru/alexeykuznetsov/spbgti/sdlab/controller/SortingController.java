package ru.alexeykuznetsov.spbgti.sdlab.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alexeykuznetsov.spbgti.sdlab.dto.ArrayUnitCreateDto;
import ru.alexeykuznetsov.spbgti.sdlab.entity.ArrayUnit;
import ru.alexeykuznetsov.spbgti.sdlab.service.ArrayUnitService;

@Controller
@RequestMapping("/arrayUnit")
@RequiredArgsConstructor
public class SortingController {

  private final ArrayUnitService arrayUnitService;

  @GetMapping
  public String startPage() {
    return "startPage";
  }

  @GetMapping("/prepare")
  public String arrayFillForm(Model model) {
    model.addAttribute("arrayUnitDto", new ArrayUnitCreateDto());
    return "arrayFillForm";
  }

  @PostMapping("/create")
  public String createArrayUnit(@ModelAttribute("arrayInputDto") ArrayUnitCreateDto arrayUnitCreateDto, Model model) {
    ArrayUnit arrayUnit = arrayUnitService.createArrayUnit(arrayUnitCreateDto);
    model.addAttribute("arrayId", arrayUnit.getId());
    return "arrayFillResult";
  }

  @PostMapping("/viewInfo")
  public String viewArrayUnitInfo(@RequestParam UUID id, Model model) {
    ArrayUnit arrayUnit = arrayUnitService.getArrayUnitById(id);
    model.addAttribute("arrayUnit", arrayUnit);
    return "arrayUnitView";
  }

  @GetMapping("/{id}")
  public String viewArrayUnit(@PathVariable UUID id, Model model) {
    ArrayUnit arrayUnit = arrayUnitService.getArrayUnitById(id);
    model.addAttribute("arrayUnit", arrayUnit);
    return "arrayUnitView";
  }

  @PostMapping("/sort")
  public String sortArrayUnit(@RequestParam UUID id, Model model) {
    ArrayUnit arrayUnit = arrayUnitService.sortArrayUnitData(id);
    model.addAttribute("arrayUnit", arrayUnit);
    model.addAttribute("sortedArray", arrayUnit.getSortedData());
    return "arrayUnitView";
  }

  @PostMapping("/delete")
  public String deleteArrayUnit(@RequestParam UUID id) {
    arrayUnitService.deleteArrayUnit(id);
    return "deletedArrayUnitView";
  }

  @GetMapping("/all")
  public String findAllArrayUnits(Model model) {
    List<ArrayUnit> arrayUnits = arrayUnitService.findAll();
    model.addAttribute("arrayUnits", arrayUnits);
    return "scroller";
  }

  @GetMapping("/edit")
  public String editArrayUnitForm(@RequestParam UUID id, Model model) {
    ArrayUnit arrayUnit = arrayUnitService.getArrayUnitByIdForUpdate(id);
    model.addAttribute("arrayUnit", arrayUnit);
    return "editArray";
  }

  @PostMapping("/edit")
  public String editArrayUnit(@ModelAttribute ArrayUnit arrayUnit, Model model) {
    arrayUnitService.editArrayUnit(arrayUnit);
    return "arrayUnitView";
  }
}
