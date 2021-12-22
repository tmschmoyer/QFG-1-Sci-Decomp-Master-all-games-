;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include game.sh)
(use Intrface)
(use Game)
(use User)
(use Menu)
(use System)

(public
	DEMO 0
)

(local
	ego					;pointer to ego
	theGame				;ID of the Game instance
	curRoom				;ID of current room
	speed				;game speed (number of ticks between animations)
	quit				;when TRUE, quit game
	cast				;collection of actors
	regions				;set of current regions
	timers				;list of timers in the game
	sounds				;set of sounds being played
	inventory			;set of inventory items in game
	addToPics			;list of views added to the picture
	curRoomNum			;current room number
	prevRoomNum			;previous room number
	newRoomNum			;number of room to change to
	debugOn				;generic debug flag -- set from debug menu
	score				;the player's current score
	possibleScore		;highest possible score
	showStyle			;style of picture showing
	aniInterval			;the # of ticks it took to do the last animation cycle
	theCursor			;the number of the current cursor
	normalCursor		;number of normal cursor form
	waitCursor			;cursor number of "wait" cursor
	userFont			;font to use for Print
	smallFont			;small font for save/restore, etc.
	lastEvent			;the last event (used by save/restore game)
	modelessDialog		;the modeless Dialog known to User and Intrface
	bigFont				;large font
	volume				;sound volume for machines with control over it
	version				;pointer to "x.yyy.zzz"
	locales				;set of current locales
	[curSaveDir 20]		;address of current save drive/directory string
	aniThreshold
	perspective			;player's viewing angle:
						;	 degrees away from vertical along y axis								
	features			;locations that may respond to events
	sortedFeatures		;above sorted by "visibility" to ego
	sortedCast			;cast sorted by "visibility" to ego
	deleteCastMember	;a member of the cast needs deleting
	skipFactor			;default=1, set to 2 or 3 if we're really crawling
	;globals 57-99 are unused
		global57
		global58
		global59
		global60
		global61
		global62
		global63
		global64
		global65
		global66
		global67
		global68
		global69
		global70
		global71
		global72
		global73
		global74
		global75
		global76
		global77
		global78
		global79
		global80
		global81
		global82
		global83
		global84
		global85
		global86
		global87
		global88
		global89
		global90
		global91
		global92
		global93
		global94
		global95
		global96
		global97
		global98
	lastSysGlobal
	global100
	global101
	global102
	global103
	global104
	global105
	global106
	global107
	global108
	global109
	global110
	global111
	global112
	global113
	global114
	global115
	global116
	global117
	global118
	global119
	global120
	global121
	global122
	global123
	global124
	global125
	global126
	global127
	global128
	global129
	global130
	global131
	global132
	global133
	global134
	global135
	global136
	global137
	global138
	global139
	global140
	global141
	global142
	global143
	global144
	global145
	global146
	global147
	global148
	global149
	global150
	global151
	global152
	global153
	global154
	global155
	global156
	global157
	global158
	global159
	global160
	global161
	global162
	global163
	global164
	global165
	global166
	global167
	global168
	global169
	global170
	global171
	global172
	global173
	global174
	global175
	global176
	global177
	global178
	global179
	global180
	global181
	global182
	global183
	global184
	global185
	global186
	global187
	global188
	global189
	global190
	global191
	global192
	global193
	global194
	global195
	global196
	global197
	global198
	global199
	global200
	global201
	global202
	global203
	global204
	global205
	global206
	global207
	global208
	global209
	global210
	global211
	global212
	global213
	global214
	global215
	global216
	global217
	global218
	global219
	global220
	global221
	global222
	global223
	global224
	global225
	global226
	global227
	global228
	global229
	global230
	global231
	global232
	global233
	global234
	global235
	global236
	global237
	global238
	global239
	global240
	global241
	global242
	global243
	global244
	global245
	global246
	global247
	global248
	global249
	global250
	global251
	global252
	global253
	global254
	global255
	global256
	global257
	global258
	global259
	global260
	global261
	global262
	global263
	global264
	global265
	global266
	global267
	global268
	global269
	global270
	global271
	global272
	global273
	global274
	global275
	global276
	global277
	global278
	global279
	global280
	global281
	global282
	global283
	global284
	global285
	global286
	global287
	global288
	global289
	global290
	global291
	global292
	global293
	global294
	global295
	global296
	global297
	global298
	global299
	strIndex
	global301
	global302
	christmasCursor
	global304
	global305
	global306
	global307
	global308
	global309
	global310
	global311
	global312
	global313
	global314
	global315
	global316
	global317
	global318
	global319
	global320
	global321
	global322
	global323
	global324
	global325
	global326
	global327
	global328
	global329
	customBuf
		global331
		global332
		global333
		global334
		global335
		global336
		global337
		global338
		global339
		global340
		global341
		global342
		global343
		global344
		global345
		global346
		global347
		global348
		global349
		global350
		global351
		global352
		global353
		global354
		global355
		global356
		global357
		global358
		global359
		global360
		global361
		global362
		global363
		global364
		global365
		global366
		global367
		global368
		global369
		global370
		global371
		global372
		global373
		global374
		global375
		global376
		global377
		global378
		global379
	str
		global381
		global382
		global383
		global384
		global385
		global386
		global387
		global388
		global389
		global390
		global391
		global392
		global393
		global394
		global395
		global396
		global397
		global398
		global399
		global400
		global401
		global402
		global403
		global404
		global405
		global406
		global407
		global408
		global409
		global410
		global411
		global412
		global413
		global414
		global415
		global416
		global417
		global418
		global419
		global420
		global421
		global422
		global423
		global424
		global425
		global426
		global427
		global428
		global429
		global430
		global431
		global432
		global433
		global434
		global435
		global436
		global437
		global438
		global439
		global440
		global441
		global442
		global443
		global444
		global445
		global446
		global447
		global448
		global449
		global450
		global451
		global452
		global453
		global454
		global455
		global456
		global457
		global458
		global459
		global460
		global461
		global462
		global463
		global464
		global465
		global466
		global467
		global468
		global469
		global470
		global471
		global472
		global473
		global474
		global475
		global476
		global477
		global478
		global479
		global480
		global481
		global482
		global483
		global484
		global485
		global486
		global487
		global488
		global489
		global490
		global491
		global492
		global493
		global494
		global495
		global496
		global497
		global498
		global499
		global500
		global501
		global502
		global503
		global504
		global505
		global506
		global507
		global508
		global509
		global510
		global511
		global512
		global513
		global514
		global515
		global516
		global517
		global518
		global519
		global520
		global521
		global522
		global523
		global524
		global525
		global526
		global527
		global528
		global529
		global530
		global531
		global532
		global533
		global534
		global535
		global536
		global537
		global538
		global539
		global540
		global541
		global542
		global543
		global544
		global545
		global546
		global547
		global548
		global549
		global550
		global551
		global552
		global553
		global554
		global555
		global556
		global557
		global558
		global559
		global560
		global561
		global562
		global563
		global564
		global565
		global566
		global567
		global568
		global569
		global570
		global571
		global572
		global573
		global574
		global575
		global576
		global577
		global578
		global579
		global580
		global581
		global582
		global583
		global584
		global585
		global586
		global587
		global588
		global589
		global590
		global591
		global592
		global593
		global594
		global595
		global596
		global597
		global598
		global599
		global600
		global601
		global602
		global603
		global604
		global605
		global606
		global607
		global608
		global609
		global610
		global611
		global612
		global613
		global614
		global615
		global616
		global617
		global618
		global619
		global620
		global621
		global622
		global623
		global624
		global625
		global626
		global627
		global628
		global629
	theLen
		global631
		global632
		global633
		global634
		global635
		global636
		global637
		global638
		global639
		global640
		global641
		global642
		global643
		global644
		global645
		global646
		global647
		global648
		global649
		global650
		global651
		global652
		global653
		global654
		global655
		global656
		global657
		global658
		global659
		global660
		global661
		global662
		global663
		global664
		global665
		global666
		global667
		global668
		global669
		global670
		global671
		global672
		global673
		global674
		global675
		global676
		global677
		global678
		global679
		global680
		global681
		global682
		global683
		global684
		global685
		global686
		global687
		global688
		global689
		global690
		global691
		global692
		global693
		global694
		global695
		global696
		global697
		global698
		global699
		global700
		global701
		global702
		global703
		global704
		global705
		global706
		global707
		global708
		global709
		global710
		global711
		global712
		global713
		global714
		global715
		global716
		global717
		global718
		global719
		global720
		global721
		global722
		global723
		global724
		global725
		global726
		global727
		global728
		global729
		global730
		global731
		global732
		global733
		global734
		global735
		global736
		global737
		global738
		global739
		global740
		global741
		global742
		global743
		global744
		global745
		global746
		global747
		global748
		global749
		global750
		global751
		global752
		global753
		global754
		global755
		global756
		global757
		global758
		global759
		global760
		global761
		global762
		global763
		global764
		global765
		global766
		global767
		global768
		global769
		global770
		global771
		global772
		global773
		global774
		global775
		global776
		global777
		global778
		global779
		global780
		global781
		global782
		global783
		global784
		global785
		global786
		global787
		global788
		global789
		global790
		global791
		global792
		global793
		global794
		global795
		global796
		global797
		global798
		global799
		global800
		global801
		global802
		global803
		global804
		global805
		global806
		global807
		global808
		global809
		global810
		global811
		global812
		global813
		global814
		global815
		global816
		global817
		global818
		global819
		global820
		global821
		global822
		global823
		global824
		global825
		global826
		global827
		global828
		global829
		global830
		global831
		global832
		global833
		global834
		global835
		global836
		global837
		global838
		global839
		global840
		global841
		global842
		global843
		global844
		global845
		global846
		global847
		global848
		global849
		global850
		global851
		global852
		global853
		global854
		global855
		global856
		global857
		global858
		global859
		global860
		global861
		global862
		global863
		global864
		global865
		global866
		global867
		global868
		global869
		global870
		global871
		global872
		global873
		global874
		global875
		global876
		global877
		global878
		global879
		global880
		global881
		global882
		global883
		global884
		global885
		global886
		global887
		global888
		global889
		global890
		global891
		global892
		global893
		global894
		global895
		global896
		global897
		global898
		global899
	christmasBuf
		global901
		global902
		global903
		global904
		global905
		global906
		global907
		global908
		global909
		global910
		global911
		global912
		global913
		global914
		global915
		global916
		global917
		global918
		global919
	newYearBuf
		global921
		global922
		global923
		global924
		global925
		global926
		global927
		global928
		global929
		global930
		global931
		global932
		global933
		global934
		global935
		global936
		global937
		global938
		global939
	seasonsBuf
		global941
		global942
		global943
		global944
		global945
		global946
		global947
		global948
		global949
		global950
		global951
		global952
		global953
		global954
		global955
		global956
		global957
		global958
		global959
	holidayBuf
		global961
		global962
		global963
		global964
		global965
		global966
		global967
		global968
		global969
		global970
		global971
		global972
		global973
		global974
		global975
		global976
		global977
		global978
		global979
		global980
)
(instance statusCode of Code
	(method (doit strg)
		(Format strg 0 0
			{________Merry Christmas from Sierra On-Line!}
		)
	)
)

(instance DEMO of Game
	(method (init)
		(super init:)
		(TheMenuBar init:)
		(User canInput: FALSE)
		(User canControl: FALSE)
		(StatusLine code: statusCode)
		(StatusLine enable:)
		(= waitCursor 994)
		(= christmasCursor 994)
		(= normalCursor christmasCursor)
		(self newRoom: 8)
	)
)
