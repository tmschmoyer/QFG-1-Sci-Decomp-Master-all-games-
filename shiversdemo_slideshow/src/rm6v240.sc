;;; Sierra Script 1.0 - (do not remove this comment)
(script# 6240)
(include sci.sh)
(use Main)
(use Procs)
(use String)
(use Reverse)
(use Motion)
(use Actor)
(use System)

(public
	rm6v240 0
)

(local
	local0
	local1
	local2
)
(instance rm6v240 of ShiversRoom
	(properties
		picture 6240
	)
	
	(method (init)
		(= local0 0)
		(= local1 0)
		(efExitBack init: 8)
		(hsPlay init:)
		(hsRewind init:)
		(pButton init:)
		(pCassetteDeck init:)
		(sounds fade: 20601 0 15 8 1 0)
		(sounds fadeChain:)
		(super init: &rest)
	)
	
	(method (newRoom)
		(self eraseText:)
		(sounds stop: 20601)
		(sounds interruptChain:)
		(sounds stop: 10604)
		(sounds stop: 10605)
		(sounds stop: 30601)
		(sounds stop: 30602)
		(sounds stop: 30611)
		(sounds stop: 30612)
		(sounds stop: 30613)
		(proc951_7 20601)
		(proc951_9 20601)
		(sounds play: 20601 -1 0 0)
		(sounds fade: 20601 10 15 5 0 0)
		(sounds playChain: -1 -4 20602 -1)
		(sounds adjChainVol: 34)
		(super newRoom: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 6220
	)
	
	(method (init)
		(self
			createPoly:
				96
				21
				95
				2
				1
				1
				0
				142
				262
				142
				262
				0
				97
				1
				97
				20
				161
				20
				172
				119
				170
				123
				87
				124
		)
		(super init: &rest)
	)
)

(instance hsPlay of HotSpot
	(properties)
	
	(method (init)
		(self createPoly: 122 117 122 102 135 102 135 117)
		(super init: &rest)
	)
	
	(method (doVerb)
		(if (not (if local1 else local0))
			(proc951_16 144)
			(sounds stop: 20601)
			(sounds interruptChain:)
			(curRoom setScript: sPlay)
		)
	)
)

(instance hsRewind of HotSpot
	(properties)
	
	(method (init)
		(self createPoly: 111 102 122 102 122 117 111 117)
		(super init: &rest)
	)
	
	(method (doVerb)
		(if (not local1)
			(sounds stop: 30601)
			(sounds stop: 30602)
			(sounds stop: 30611)
			(sounds stop: 30612)
			(sounds stop: 30613)
			(curRoom eraseText:)
			(curRoom setScript: sRewind)
		)
	)
)

(instance pButton of Prop
	(properties
		priority 25
		fixPriority 1
		view 6240
	)
)

(instance pCassetteDeck of ShiversProp
	(properties
		view 6240
		loop 2
	)
	
	(method (init)
		(self setPri: 100 1 setCel: 0)
		(super init: &rest)
	)
)

(instance sPlay of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theGame handsOff:)
				(pButton loop: 0 cel: 1)
				(proc951_7 30601)
				(= cycles 1)
			)
			(1
				(theGame handsOn:)
				(= local0 1)
				(pCassetteDeck cycleSpeed: 15 setCycle: Fwd)
				(if (proc951_5 40)
					(= local2
						(Str
							format:
								{ 30th September, 1980. Returning from Africa. I discovered something profoundly disturbing. Someone has been here. Furniture has been tipped__________over._}
						)
					)
					(curRoom drawText: local2 0 0)
					(local2 data: 0 dispose:)
					(sounds play: 30611 0 122 self)
				else
					(sounds play: 30601 0 122 self)
					(= state (+ state 3))
				)
			)
			(2
				(= local2
					(Str
						format:
							{ And the book Egyptian Hieroglyphics Explained is not in it's place in the library, but face down here on the office floor. And oddly, one of the pages is__torn out._}
					)
				)
				(curRoom drawText: local2)
				(local2 data: 0 dispose:)
				(sounds play: 30612 0 122 self)
			)
			(3
				(= local2
					(Str
						format:
							{ And I feel the presence of...I'm not sure. I must investigate the second floor. The puzzles...when I created them, I never stopped to think they'd become an____obstacle in the event of some terrible occurrance._}
					)
				)
				(curRoom drawText: local2)
				(local2 data: 0 dispose:)
				(sounds play: 30613 0 122 self)
			)
			(4
				(if (proc951_5 40) (curRoom eraseText:))
				(theGame handsOff:)
				(proc951_8 30601)
				(proc951_7 30602)
				(= cycles 1)
			)
			(5
				(theGame handsOn:)
				(if (proc951_5 40)
					(= local2
						(Str
							format:
								{ The Ixupi! Someone has released them from their vessels! Never has anything been so evil! A name written in the lift: Merrick. Who is he, one of the missing youngsters? Here in my museum? If so, are they both here? Can they still be alive?_}
						)
					)
					(curRoom drawText: local2)
					(local2 data: 0 dispose:)
					(sounds play: 30621 0 122 self)
				else
					(sounds play: 30602 0 122 self)
					(= state (+ state 3))
				)
			)
			(6
				(= local2
					(Str
						format:
							{ Evil entities attacking from everywhere, robbing me of my life essence! I__________can't seem to find the right vessel for each Ixupi! Without it they can't be captured! Without it, I am doomed!_}
					)
				)
				(curRoom drawText: local2)
				(local2 data: 0 dispose:)
				(sounds play: 30622 0 122 self)
			)
			(7
				(= local2
					(Str
						format:
							{ Aaahhhh... (Evil entity growls) Get back! Get back! Get out of my museum. Oh, I wish I had never brought you here...._}
					)
				)
				(curRoom drawText: local2 0 9)
				(local2 data: 0 dispose:)
				(sounds play: 30623 0 122 self)
			)
			(8
				(if (proc951_5 40) (curRoom eraseText:))
				(pCassetteDeck cycleSpeed: 6 setCycle: Rev)
				(proc951_8 30602)
				(= local0 0)
				(= local1 1)
				(pButton loop: 1 cel: 1)
				(sounds play: 10605 0 50 self)
			)
			(9
				(pCassetteDeck setCycle: 0 setCel: 0)
				(pButton cel: 0)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance sRewind of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc951_5 40) (curRoom eraseText:))
				(theGame handsOff:)
				(= local0 0)
				(= local1 1)
				(pCassetteDeck cycleSpeed: 6 setCycle: Rev)
				(pButton loop: 1 cel: 1)
				(sounds play: 10605 0 50 self)
			)
			(1
				(pCassetteDeck setCycle: 0 setCel: 0)
				(pButton cel: 0)
				(= local1 0)
				(theGame handsOn:)
				(self dispose:)
			)
		)
	)
)
