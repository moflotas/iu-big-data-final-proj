lint:
	pylint */*.py

preprocess:
	bash ./scripts/preprocess.sh

stage-1:
	bash ./scripts/stage1.sh

stage-2:
	bash ./scripts/stage2.sh
