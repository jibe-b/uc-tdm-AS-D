/*
Copyright 2016, 2017 Institut National de la Recherche Agronomique

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


package org.bibliome.alvisnlp.modules.keyword;

public enum Frequency implements KeywordScoreFunction {
	ABSOLUTE {
		@Override
		public boolean requiresDocumentLength() {
			return false;
		}

		@Override
		public double getScore(long freq, long docFreq, long maxFreq, long docLength, long numDocs, long totalFreq) {
			return freq;
		}
	},
	
	RELATIVE_TO_DOCUMENT_LENGTH {
		@Override
		public boolean requiresDocumentLength() {
			return true;
		}

		@Override
		public double getScore(long freq, long docFreq, long maxFreq, long docLength, long numDocs, long totalFreq) {
			return ((double) freq) / docLength;
		}
	};

	@Override
	public boolean requiresNumberOfDocuments() {
		return false;
	}

	@Override
	public boolean requiresDocumentFrequency() {
		return false;
	}

	@Override
	public boolean requiresMaxFrequency() {
		return false;
	}

	@Override
	public boolean requiresCorpusLength() {
		return false;
	}
}