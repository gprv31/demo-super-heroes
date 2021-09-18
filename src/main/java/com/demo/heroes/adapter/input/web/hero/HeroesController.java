package com.demo.heroes.adapter.input.web.hero;

import com.demo.heroes.adapter.input.web.hero.model.request.HeroEditRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.request.PagedHeroesRestRequest;
import com.demo.heroes.adapter.input.web.hero.model.response.HeroRestResponse;
import com.demo.heroes.adapter.input.web.hero.model.response.PagedHeroesRestResponse;
import com.demo.heroes.adapter.input.web.hero.validators.NumberValid;
import com.demo.heroes.application.exception.HeroExceptionResponse;
import com.demo.heroes.application.log.LogExecuteTimeMethod;
import com.demo.heroes.domain.port.input.GetHeroInformationUseCase;
import com.demo.heroes.domain.port.input.ModifyHeroInformationUseCase;
import com.demo.heroes.entity.hero.Hero;
import com.demo.heroes.entity.hero.request.HeroEditRequest;
import com.demo.heroes.entity.hero.request.PagedHeroesRequest;
import com.demo.heroes.entity.hero.response.PagedHeroesResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.function.Function;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/heroes")
@RequiredArgsConstructor
@Validated
@Tag(name = "Heroes", description = "Heroes Controller")
public class HeroesController {

  private final GetHeroInformationUseCase getHeroInformationUseCase;
  private final ModifyHeroInformationUseCase modifyHeroInformationUseCase;

  private final Function<PagedHeroesRestRequest, PagedHeroesRequest> pagedHeroesRequestConverter;
  private final Function<HeroEditRestRequest, HeroEditRequest> heroEditRequestConverter;

  private final Function<PagedHeroesResponse, PagedHeroesRestResponse> pagedHeroesRestResponseConverter;
  private final Function<Hero, HeroRestResponse> heroRestResponseConverter;

  @InitBinder
  public void initBinder(DataBinder binder) {
    binder.setDisallowedFields();
  }


  /**
   * Get all heroes information by filter.
   *
   * @param pagedHeroesRestRequest {@link PagedHeroesRestRequest}
   * @return {@link PagedHeroesRestResponse}
   *
   */
  @LogExecuteTimeMethod
  @GetMapping(value = "")
  @Operation(summary = "Get all Heroes information by filter.", description = "Get heroes information.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Already OK.",
      content = {@Content(schema = @Schema(implementation = PagedHeroesRestResponse.class))}),
    @ApiResponse(responseCode = "400", description = "Bad Request.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "500",
      description = "Internal Server Error.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "503",
      description = "Service Unavailable.",
      content = {@Content(schema = @Schema(implementation = Exception.class))})
  })
  public Single<PagedHeroesRestResponse> getHeroes(@Valid PagedHeroesRestRequest pagedHeroesRestRequest) {
    log.info("Starting HeroesController.getHeroes method");
    return getHeroInformationUseCase.getHeroes(pagedHeroesRequestConverter.apply(pagedHeroesRestRequest))
             .map(pagedHeroesRestResponseConverter::apply)
             .doOnSuccess(i -> log.info("Finished HeroesController.getHeroes method"))
             .doOnError(e -> log.error("Finished HeroesController.getHeroes method with error", e));
  }


  /**
   * Get hero information by indentifier.
   *
   * @param heroId String
   * @return {@link HeroRestResponse}
   *
   */
  @LogExecuteTimeMethod
  @GetMapping(value = "/{heroId}")
  @Operation(summary = "Get Hero information by identifier.", description = "Get hero by identifier.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Already OK.",
      content = {@Content(schema = @Schema(implementation = HeroRestResponse.class))}),
    @ApiResponse(responseCode = "400", description = "Bad Request.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "500",
      description = "Internal Server Error.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "503",
      description = "Service Unavailable.",
      content = {@Content(schema = @Schema(implementation = Exception.class))})
  })
  public Single<HeroRestResponse> getHeroById(
      @PathVariable(value = "heroId")
      @NumberValid
      @Schema(description = "Hero identifier", example = "1") String heroId) {
    log.info("Starting HeroesController.getHeroById method");
    return getHeroInformationUseCase.getHeroById(Long.valueOf(heroId))
             .map(heroRestResponseConverter::apply)
             .doOnSuccess(i -> log.info("Finished HeroesController.getHeroById method"))
             .doOnError(e -> log.error("Finished HeroesController.getHeroById method with error", e));
  }

  /**
   * Delete Hero by identifier.
   *
   * @param heroId String
   * @return {@link Completable}
   *
   */
  @LogExecuteTimeMethod
  @DeleteMapping(value = "/{heroId}")
  @Operation(summary = "Delete Hero by identifier.", description = "Delete hero by identifier.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Already OK."),
    @ApiResponse(responseCode = "400", description = "Bad Request.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "500",
      description = "Internal Server Error.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "503",
      description = "Service Unavailable.",
      content = {@Content(schema = @Schema(implementation = Exception.class))})
  })
  public Completable deleteHeroById(
      @PathVariable(value = "heroId")
      @NumberValid
      @Schema(description = "Hero identifier", example = "1") String heroId) {
    log.info("Starting HeroesController.deleteHeroById method");
    return modifyHeroInformationUseCase.deleteHeroById(Long.valueOf(heroId))
             .doOnComplete(() -> log.info("Finished HeroesController.deleteHeroById method"))
             .doOnError(e -> log.error("Finished HeroesController.deleteHeroById method with error", e));
  }


  /**
   * Modify Hero information by identifier.
   *
   * @param heroEditRestRequest {@link HeroEditRestRequest}
   * @return {@link HeroRestResponse}
   *
   */
  @LogExecuteTimeMethod
  @PatchMapping(value = "")
  @Operation(summary = "Modify Hero information by identifier.", description = "Modify hero by identifier.")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Already OK.",
      content = {@Content(schema = @Schema(implementation = HeroRestResponse.class))}),
    @ApiResponse(responseCode = "400", description = "Bad Request.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "500",
      description = "Internal Server Error.",
      content = {@Content(schema = @Schema(implementation = HeroExceptionResponse.class))}),
    @ApiResponse(responseCode = "503",
      description = "Service Unavailable.",
      content = {@Content(schema = @Schema(implementation = Exception.class))})
  })
  public Single<HeroRestResponse> modifyHeroById(@Valid @RequestBody HeroEditRestRequest heroEditRestRequest) {
    log.info("Starting HeroesController.modifyHeroById method");
    return modifyHeroInformationUseCase.modifyHeroById(heroEditRequestConverter.apply(heroEditRestRequest))
             .map(heroRestResponseConverter::apply)
             .doOnSuccess(i -> log.info("Finished HeroesController.modifyHeroById method"))
             .doOnError(e -> log.error("Finished HeroesController.modifyHeroById method with error", e));
  }

}
